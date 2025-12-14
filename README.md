# App de Sensores ESCOM - Práctica 6

## Información del Estudiante

**Nombre:** Cortés Buendía Martín Francisco  
**Boleta:** 2022630507  
**Asignatura:** Desarrollo de Aplicaciones Móviles Nativas  
**Práctica:** Práctica 6 - Manejo de Sensores del Dispositivo Móvil  
**Fecha de Entrega:** 01 de Diciembre de 2025

---

## Descripción del Proyecto

Aplicación Android nativa desarrollada en Kotlin con Jetpack Compose que implementa el uso de sensores del dispositivo móvil (proximidad y luz ambiental) con funcionalidades interactivas y temas personalizables representativos del IPN y la ESCOM.

La aplicación permite a los usuarios interactuar con los sensores del dispositivo en tiempo real, visualizar los datos capturados y realizar acciones basadas en la proximidad de objetos.

---

## Características Principales

### ✅ Sensores Implementados

1. **Sensor de Proximidad**
   - Detecta objetos cercanos al dispositivo
   - Rango de detección: 0-5 cm
   - Alerta visual cuando detecta objetos a menos de 5 cm
   - Habilita/deshabilita funcionalidad de captura

2. **Sensor de Luz Ambiental**
   - Mide la iluminación del entorno en lux
   - Clasificación automática de condiciones de luz:
     - 🌑 Muy oscuro (< 10 lux)
     - 🌘 Oscuro (10-50 lux)
     - ☁️ Poca luz (50-200 lux)
     - 🌤️ Iluminación normal (200-1000 lux)
     - ☀️ Muy iluminado (> 1000 lux)

### 🎨 Temas Personalizables

- **Tema Sistema:** Adaptación automática al modo claro/oscuro del dispositivo
- **Tema Guinda IPN:** Colores representativos del Instituto Politécnico Nacional
- **Tema Azul ESCOM:** Colores representativos de la Escuela Superior de Cómputo

### 📱 Funcionalidades

- Visualización de datos de sensores en tiempo real
- Control individual de activación/desactivación de sensores
- Simulación de captura de eventos basada en proximidad
- Contador de capturas realizadas
- Gestión eficiente de recursos y batería
- Interfaz intuitiva con Material Design 3

---

## Requisitos Técnicos

### Requisitos del Sistema

- **Sistema Operativo:** Android 7.0 (API 24) o superior
- **Lenguaje:** Kotlin
- **Framework UI:** Jetpack Compose
- **Sensores Requeridos:**
  - Sensor de proximidad
  - Sensor de luz ambiental

### Dependencias Principales

```gradle
dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
}
```

---

## Instalación y Configuración

### Opción 1: Instalación desde APK

1. Descarga el archivo APK desde la sección de releases
2. Habilita "Orígenes desconocidos" en tu dispositivo Android
3. Instala el APK
4. Abre la aplicación y otorga los permisos necesarios

### Opción 2: Compilación desde código fuente

1. **Clonar el repositorio:**
```bash
git clone https://github.com/MartinCortes20/practica6Moviles
cd practica6-sensores
```

2. **Abrir en Android Studio:**
   - Android Studio Hedgehog | 2023.1.1 o superior
   - Gradle 8.0 o superior

3. **Sincronizar dependencias:**
   - Esperar a que Gradle sincronice automáticamente
   - O ejecutar: `./gradlew build`

4. **Ejecutar la aplicación:**
   - Conectar dispositivo físico vía USB (recomendado para sensores reales)
   - Hacer clic en "Run" o presionar `Shift + F10`

---

## Uso de la Aplicación

### Instrucciones de Uso

1. **Seleccionar Tema:**
   - Al iniciar la app, selecciona tu tema preferido:
     - Sistema (predeterminado)
     - IPN Guinda
     - ESCOM Azul

2. **Activar Sensores:**
   - Usa los interruptores para habilitar/deshabilitar cada sensor
   - Los datos se actualizarán en tiempo real cuando estén activos

3. **Capturar Eventos:**
   - Activa el sensor de proximidad
   - Acerca tu mano u objeto al sensor del dispositivo (< 5 cm)
   - Presiona el botón "📸 Tomar Foto"
   - Se incrementará el contador de capturas

4. **Visualizar Datos:**
   - Los valores de proximidad y luz se muestran en tiempo real
   - La aplicación indica las condiciones actuales de iluminación

---

## Capturas de Pantalla

### Pantalla Principal - Tema Sistema (Modo Claro)

![Pantalla Principal Modo Claro]

<img width="319" height="726" alt="Captura de pantalla 2025-12-14 a la(s) 5 37 04 p m" src="https://github.com/user-attachments/assets/1c87499a-2ef0-41f7-88a7-0c6e9590a5e5" />


*Descripción: Vista principal de la aplicación en modo claro con sensores desactivados*

---

### Pantalla Principal - Tema Sistema (Modo Oscuro)

![Pantalla Principal Modo Oscuro]

<img width="319" height="726" alt="Captura de pantalla 2025-12-14 a la(s) 5 37 23 p m" src="https://github.com/user-attachments/assets/bd836662-ab9f-4be8-9a5f-e53076beec3f" />


*Descripción: Vista principal de la aplicación en modo oscuro con sensores desactivados*

---

### Tema IPN Guinda - Modo Claro

![Tema IPN Guinda Claro]

<img width="319" height="721" alt="Captura de pantalla 2025-12-14 a la(s) 5 37 52 p m" src="https://github.com/user-attachments/assets/7696cf24-1240-4a02-b9b5-05834c735b06" />


*Descripción: Aplicación con tema Guinda del IPN en modo claro*

---

### Tema IPN Guinda - Modo Oscuro

![Tema IPN Guinda Oscuro]

<img width="319" height="721" alt="Captura de pantalla 2025-12-14 a la(s) 5 38 56 p m" src="https://github.com/user-attachments/assets/6560f334-d48b-43b1-91a3-74fbda658219" />


*Descripción: Aplicación con tema Guinda del IPN en modo oscuro*

---

### Tema ESCOM Azul - Modo Claro

![Tema ESCOM Azul Claro]

<img width="319" height="721" alt="Captura de pantalla 2025-12-14 a la(s) 5 38 10 p m" src="https://github.com/user-attachments/assets/6876e528-8b91-46b5-971a-5696f027e58d" />


*Descripción: Aplicación con tema Azul de ESCOM en modo claro*

---

### Tema ESCOM Azul - Modo Oscuro

![Tema ESCOM Azul Oscuro]

<img width="319" height="721" alt="Captura de pantalla 2025-12-14 a la(s) 5 39 15 p m" src="https://github.com/user-attachments/assets/3fa889ee-db0f-4675-954c-1bdc1eee469c" />


*Descripción: Aplicación con tema Azul de ESCOM en modo oscuro*

---

### Sensores Activados - Datos en Tiempo Real

![Sensores Activos]

<img width="319" height="721" alt="Captura de pantalla 2025-12-14 a la(s) 5 39 57 p m" src="https://github.com/user-attachments/assets/ee0ae867-3410-4b76-8744-285c47eaf81d" />


*Descripción: Vista de los sensores activados mostrando datos en tiempo real*

---

### Detección de Proximidad

![Proximidad Detectada]

<img width="319" height="721" alt="Captura de pantalla 2025-12-14 a la(s) 5 40 15 p m" src="https://github.com/user-attachments/assets/e5d72561-b3c6-459b-a807-e191458f95e3" />


*Descripción: Alerta de objeto cercano detectado (< 5 cm)*

---

### Diferentes Condiciones de Luz

![Condiciones de Luz]

<img width="319" height="721" alt="Captura de pantalla 2025-12-14 a la(s) 5 40 31 p m" src="https://github.com/user-attachments/assets/9e85eb70-4638-44c2-b0a7-dc9aba1127d6" />
<img width="319" height="721" alt="Captura de pantalla 2025-12-14 a la(s) 5 40 51 p m" src="https://github.com/user-attachments/assets/4cba4307-02e2-4b98-aac1-e453e4937b7e" />
<img width="319" height="721" alt="Captura de pantalla 2025-12-14 a la(s) 5 41 03 p m" src="https://github.com/user-attachments/assets/8ef4294d-dae8-4a40-8b41-62b13129f922" />



*Descripción: Ejemplos de diferentes condiciones de iluminación detectadas*

---

### Capturas Realizadas

![Contador de Capturas]

<img width="319" height="721" alt="Captura de pantalla 2025-12-14 a la(s) 5 41 20 p m" src="https://github.com/user-attachments/assets/7af83701-9157-48f1-9eeb-9d754fba4aee" />
<img width="319" height="721" alt="Captura de pantalla 2025-12-14 a la(s) 5 41 29 p m" src="https://github.com/user-attachments/assets/aa5c8d2d-8442-464c-abc3-2fe7516a36b3" />


*Descripción: Interfaz mostrando el contador de capturas realizadas*

---

### Toast de Confirmación

![Toast Captura Exitosa]

<img width="319" height="721" alt="Captura de pantalla 2025-12-14 a la(s) 5 41 45 p m" src="https://github.com/user-attachments/assets/b6d0a7c3-b32c-4ad7-9c9d-d9c0bf20911f" />


*Descripción: Mensaje de confirmación al capturar un evento*

---

### Toast de Advertencia

![Toast Advertencia]

<img width="319" height="721" alt="Captura de pantalla 2025-12-14 a la(s) 5 42 00 p m" src="https://github.com/user-attachments/assets/909bd754-764d-4b2d-8224-f4114a77b922" />


*Descripción: Advertencia cuando se intenta capturar sin objeto cercano*

---

## Arquitectura de la Aplicación

### Componentes Principales

```
com.escom.practica6/
├── MainActivity.kt              # Actividad principal
├── SensorApp.kt                # Composable principal
├── CustomAppTheme.kt           # Sistema de temas
├── ColorSchemes.kt             # Esquemas de colores
└── ui/
    ├── components/
    │   ├── SwitchWithLabel.kt  # Switch personalizado
    │   └── SensorDataRow.kt    # Fila de datos de sensor
    └── theme/
        └── Theme.kt            # Configuración de Material Theme
```

### Gestión de Sensores

- **SensorManager:** Gestión centralizada de sensores
- **SensorEventListener:** Escucha de eventos de sensores
- **LaunchedEffect:** Registro/desregistro automático de listeners
- **DisposableEffect:** Limpieza de recursos al destruir la vista

### Optimización de Batería

- Uso de `SENSOR_DELAY_UI` para reducir frecuencia de actualización
- Desregistro automático de sensores cuando no están en uso
- Limpieza de recursos en el ciclo de vida de la aplicación

---

## Gestión de Permisos

La aplicación no requiere permisos especiales en el AndroidManifest.xml ya que los sensores de proximidad y luz ambiental son sensores normales (no peligrosos) según la política de Android.

---

## Pruebas Realizadas

### Dispositivos de Prueba

| Dispositivo | Versión Android | Sensor Proximidad | Sensor Luz | Resultado |
|-------------|-----------------|-------------------|------------|-----------|
| [Modelo 1]  | Android XX      | ✅ Funcional      | ✅ Funcional | ✅ Exitoso |
| [Modelo 2]  | Android XX      | ✅ Funcional      | ✅ Funcional | ✅ Exitoso |
| [Modelo 3]  | Android XX      | ✅ Funcional      | ❌ No disponible | ⚠️ Parcial |

### Casos de Prueba

1. **Activación/Desactivación de Sensores**
   - ✅ Los sensores se activan correctamente
   - ✅ Los sensores se desactivan sin errores
   - ✅ No hay fugas de memoria

2. **Detección de Proximidad**
   - ✅ Detecta objetos a < 5 cm
   - ✅ Muestra alerta visual correctamente
   - ✅ Habilita/deshabilita botón de captura

3. **Detección de Luz Ambiental**
   - ✅ Lee valores en lux correctamente
   - ✅ Clasifica condiciones de luz apropiadamente
   - ✅ Actualiza en tiempo real

4. **Cambio de Temas**
   - ✅ Tema Sistema respeta configuración del dispositivo
   - ✅ Tema Guinda IPN se aplica correctamente
   - ✅ Tema Azul ESCOM se aplica correctamente
   - ✅ Transiciones suaves entre temas

5. **Funcionalidad de Captura**
   - ✅ Captura exitosa con proximidad < 5 cm
   - ✅ Muestra advertencia cuando proximidad > 5 cm
   - ✅ Contador incrementa correctamente
   - ✅ Toast informativo aparece

---

## Estructura del Código

### MainActivity.kt

```kotlin
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
```

### Gestión de Estado

Se utilizan los siguientes estados en Compose:

- `proximityValue`: Valor actual del sensor de proximidad
- `lightValue`: Valor actual del sensor de luz
- `useProximity`: Estado de activación del sensor de proximidad
- `useLight`: Estado de activación del sensor de luz
- `selectedTheme`: Tema seleccionado actualmente
- `photoCount`: Contador de capturas realizadas

---

## Optimizaciones Implementadas

### Rendimiento

1. **Recomposición Eficiente:**
   - Uso de `remember` para evitar recreación de objetos
   - Estados derivados para minimizar recomposiciones

2. **Gestión de Sensores:**
   - `SENSOR_DELAY_UI` en lugar de `SENSOR_DELAY_FASTEST`
   - Registro/desregistro automático basado en estado

3. **Limpieza de Recursos:**
   - `DisposableEffect` para limpieza garantizada
   - Desregistro de listeners en `onDispose`

### Batería

- Sensores solo activos cuando se necesitan
- Frecuencia de muestreo optimizada
- Sin procesamiento en segundo plano innecesario


---

## Bibliografía

1. Google Developers. (2024). *Sensors Overview*. Android Developers Documentation. https://developer.android.com/guide/topics/sensors/sensors_overview

2. Google Developers. (2024). *Motion Sensors*. Android Developers Documentation. https://developer.android.com/guide/topics/sensors/sensors_motion

3. Google Developers. (2024). *Position Sensors*. Android Developers Documentation. https://developer.android.com/guide/topics/sensors/sensors_position

4. Google Developers. (2024). *Environment Sensors*. Android Developers Documentation. https://developer.android.com/guide/topics/sensors/sensors_environment

5. Google Developers. (2024). *Jetpack Compose*. Android Developers Documentation. https://developer.android.com/jetpack/compose

6. Google Developers. (2024). *Material Design 3*. Material Design Documentation. https://m3.material.io/

7. Kotlin Foundation. (2024). *Kotlin Programming Language*. https://kotlinlang.org/docs/home.html

8. Android Developers. (2024). *Best Practices for Sensor Usage*. https://developer.android.com/guide/topics/sensors/sensors_overview#best-practices

---

## Licencia

Este proyecto fue desarrollado con fines educativos para la asignatura de Desarrollo de Aplicaciones Móviles Nativas en la Escuela Superior de Cómputo del Instituto Politécnico Nacional.

---

## Contacto

**Martín Francisco Cortés Buendía**  
Boleta: 2022630507  
ESCOM - Instituto Politécnico Nacional

---

## Agradecimientos

- Profesor Gabriel Hurtado Avilés
- Escuela Superior de Cómputo (ESCOM)
- Instituto Politécnico Nacional (IPN)

---

*Última actualización: Diciembre 2025*
