package com.escom.practica6

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.escom.practica6.ui.theme.Practica6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica6Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SensorApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SensorApp() {
    val context = LocalContext.current
    val sensorManager = remember {
        context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    // Estado para los sensores
    var proximityValue by remember { mutableFloatStateOf(0f) }
    var lightValue by remember { mutableFloatStateOf(0f) }
    var useProximity by remember { mutableStateOf(false) }
    var useLight by remember { mutableStateOf(false) }
    var selectedTheme by remember { mutableStateOf("Sistema") }

    // Listener para sensores
    val sensorListener = remember {
        object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent) {
                when (event.sensor.type) {
                    Sensor.TYPE_PROXIMITY -> {
                        proximityValue = event.values[0]
                    }
                    Sensor.TYPE_LIGHT -> {
                        lightValue = event.values[0]
                    }
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
        }
    }

    // Controlar registro de sensores
    LaunchedEffect(useProximity, useLight) {
        if (useProximity) {
            sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)?.let { sensor ->
                sensorManager.registerListener(sensorListener, sensor, SensorManager.SENSOR_DELAY_NORMAL)
            }
        } else {
            sensorManager.unregisterListener(sensorListener, sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY))
        }

        if (useLight) {
            sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)?.let { sensor ->
                sensorManager.registerListener(sensorListener, sensor, SensorManager.SENSOR_DELAY_NORMAL)
            }
        } else {
            sensorManager.unregisterListener(sensorListener, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT))
        }
    }

    // DisposableEffect para limpiar recursos
    DisposableEffect(Unit) {
        onDispose {
            sensorManager.unregisterListener(sensorListener)
        }
    }

    // Aplicar tema seleccionado
    val currentTheme = when (selectedTheme) {
        "IPN Guinda" -> AppTheme.IPN
        "ESCOM Azul" -> AppTheme.ESCOM
        else -> AppTheme.SYSTEM
    }

    // Scaffold principal
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("App de Sensores ESCOM") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            // Selector de tema
            Text("Seleccionar Tema:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("Sistema", "IPN Guinda", "ESCOM Azul").forEach { theme ->
                    FilterChip(
                        selected = selectedTheme == theme,
                        onClick = { selectedTheme = theme },
                        label = { Text(theme) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Control de sensores
            Text("Control de Sensores:", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(12.dp))

            SwitchWithLabel(
                checked = useProximity,
                onCheckedChange = { useProximity = it },
                text = "Sensor de Proximidad"
            )

            SwitchWithLabel(
                checked = useLight,
                onCheckedChange = { useLight = it },
                text = "Sensor de Luz Ambiental"
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Datos de sensores
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Datos en Tiempo Real:", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(12.dp))

                    SensorDataRow("Proximidad:", "${"%.2f".format(proximityValue)} cm", useProximity)
                    SensorDataRow("Luz ambiental:", "${"%.2f".format(lightValue)} lux", useLight)

                    // Información de proximidad
                    if (useProximity && proximityValue < 5f) {
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            "⚠️ Objeto cercano detectado!",
                            color = MaterialTheme.colorScheme.error,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón de acción
            Button(
                onClick = {
                    // Acción de tomar foto
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                enabled = useProximity
            ) {
                Text("Simular Toma de Foto")
            }

            // Información
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Instrucciones: Activa el sensor de proximidad y acerca tu mano al dispositivo para detectar objetos.",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun SwitchWithLabel(checked: Boolean, onCheckedChange: (Boolean) -> Unit, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text)
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}

@Composable
fun SensorDataRow(label: String, value: String, enabled: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label)
        Text(
            value,
            color = if (enabled) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
        )
    }
}

// Temas personalizados
enum class AppTheme {
    SYSTEM, IPN, ESCOM
}

@Composable
fun AppTheme(
    theme: AppTheme = AppTheme.SYSTEM,
    content: @Composable () -> Unit
) {
    val colorScheme = when (theme) {
        AppTheme.IPN -> ipnColorScheme
        AppTheme.ESCOM -> escomColorScheme
        else -> MaterialTheme.colorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

// Esquema de colores IPN Guinda
private val ipnColorScheme = lightColorScheme(
    primary = Color(0xFF8B0000), // Guinda
    onPrimary = Color.White,
    primaryContainer = Color(0x338B0000),
    onPrimaryContainer = Color(0xFF8B0000),
    secondary = Color(0xFF660000),
    onSecondary = Color.White
)

// Esquema de colores ESCOM Azul
private val escomColorScheme = lightColorScheme(
    primary = Color(0xFF0066CC), // Azul ESCOM
    onPrimary = Color.White,
    primaryContainer = Color(0x330066CC),
    onPrimaryContainer = Color(0xFF0066CC),
    secondary = Color(0xFF004499),
    onSecondary = Color.White
)