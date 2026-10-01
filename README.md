# Mi Universidad · Plantilla de aplicación Android

**Una base para presentar información universitaria de forma sencilla desde el teléfono.**

Mi Universidad es una plantilla inicial de una aplicación Android que reúne oferta académica, noticias del campus e información de contacto. Su interfaz permite recorrer estas secciones desde un menú lateral y consultar detalles sin salir de la pantalla actual.

El proyecto está pensado para estudiantes y desarrolladores que desean explorar una app universitaria o utilizar su estructura como punto de partida para una versión personalizada.

> **Alcance:** esta entrega corresponde a una plantilla informativa con contenido de ejemplo incluido en el proyecto. No está conectada a un sistema universitario real ni publica información en tiempo real.

## Contenido

- [Qué puedes hacer](#qué-puedes-hacer)
- [Cómo usar la aplicación](#cómo-usar-la-aplicación)
- [Alcance de esta versión](#alcance-de-esta-versión)
- [Abrir y ejecutar el proyecto](#abrir-y-ejecutar-el-proyecto)
- [Tecnologías y configuración](#tecnologías-y-configuración)
- [Organización del código](#organización-del-código)
- [Personalizar la plantilla](#personalizar-la-plantilla)

## Qué puedes hacer

| Sección o acción | Función |
| --- | --- |
| **Carreras** | Consultar cuatro carreras de ejemplo con facultad, duración, modalidad y descripción. Al tocar una tarjeta se abre la información completa. |
| **Noticias** | Consultar cuatro publicaciones de ejemplo con categoría, fecha, título y descripción. Cada tarjeta permite abrir el detalle. |
| **Contacto** | Ver una dirección, un teléfono, un correo y un horario de atención de ejemplo. |
| **Menú lateral** | Cambiar entre Carreras, Noticias y Contacto, y consultar Acerca de. |
| **Compartir app** | Abrir el selector de aplicaciones de Android para compartir un texto descriptivo. |
| **Acerca de** | Mostrar un diálogo con información de la aplicación. |
| **Salir** | Cerrar la actividad principal. |

La oferta académica de ejemplo incluye Ingeniería en Sistemas Informáticos, Administración de Empresas, Diseño Gráfico y Psicología.

## Cómo usar la aplicación

1. **Abre la app.** La primera pantalla muestra la sección Carreras.
2. **Toca una carrera.** Se abrirá una ventana con su información completa; presiona Cerrar para volver.
3. **Abre el menú lateral** con el icono de tres líneas situado en la parte superior izquierda.
4. **Selecciona Noticias o Contacto** para cambiar de sección. El título superior se actualiza según la pantalla elegida.
5. **Toca una noticia** para leer el contenido completo de la publicación de ejemplo.
6. **Explora las opciones de la barra superior.** Algunas acciones pueden aparecer dentro del menú de tres puntos, según el espacio disponible.

Si presionas Atrás mientras el menú lateral está abierto, primero se cerrará el menú.

## Alcance de esta versión

La versión **1.0** se entrega como una plantilla inicial terminada, con navegación y consulta de contenido local. Las siguientes precisiones ayudan a entender su funcionamiento:

- **Contenido local:** las carreras, noticias y datos de contacto están definidos en los recursos del proyecto. No se descargan de un servidor ni se actualizan automáticamente.
- **Consulta sin conexión:** las pantallas informativas no necesitan conexión a Internet. El envío del texto compartido depende de la aplicación externa que se elija.
- **Sin cuentas:** no requiere registro ni inicio de sesión, y no incluye perfiles, notas, matrículas ni trámites académicos.
- **Búsqueda de muestra:** el botón Buscar únicamente muestra el mensaje «Búsqueda próximamente». No filtra contenido; ese texto no implica un compromiso de futuras actualizaciones.
- **Contacto informativo:** la pantalla presenta los datos; no implementa acciones propias para llamar o enviar correos.
- **Compartir texto:** la opción Compartir app envía una descripción, no un APK ni un enlace de descarga.

Los datos incluidos sirven para mostrar la plantilla y deben revisarse o sustituirse antes de utilizarla para una institución concreta.

## Abrir y ejecutar el proyecto

Este repositorio contiene el código fuente. Para ejecutarlo en un teléfono o emulador, abre y compila el proyecto en Android Studio.

### Requisitos

- Android Studio compatible con la configuración Gradle incluida.
- Android SDK correspondiente a `compileSdk 36`, con `minorApiLevel = 1`.
- JDK 21 para el proceso de Gradle, conforme a `gradle/gradle-daemon-jvm.properties`.
- Un emulador o dispositivo con **Android 7.0 / API 24 o superior**.
- Conexión a Internet para descargar las herramientas y dependencias durante la preparación inicial.

### Pasos

1. Clona el repositorio usando su URL desde GitHub, o descarga una copia del código.
2. Abre Android Studio y selecciona **Open**.
3. Elige la carpeta raíz que contiene `settings.gradle`, `app/` y `gradlew`.
4. Espera a que termine la sincronización de Gradle y permite la instalación del SDK necesario si se solicita.
5. Selecciona un emulador o conecta un teléfono con la depuración USB habilitada y autorizada.
6. Ejecuta el módulo **app** con el botón **Run**.

El nombre configurado para la aplicación en Android es `Componentes_grupo2`; «Mi Universidad» es el título utilizado en su interfaz.

### Compilar desde PowerShell

Una vez configurados el SDK y el entorno, ejecuta desde la raíz del proyecto:

```powershell
.\gradlew.bat assembleDebug
```

El APK de depuración se genera en:

```text
app/build/outputs/apk/debug/app-debug.apk
```

Usa el Gradle Wrapper incluido para conservar la versión configurada por el proyecto. Si falla la sincronización, revisa la compatibilidad de Android Studio, el SDK instalado y el JDK seleccionado antes de cambiar las versiones.

## Tecnologías y configuración

Valores definidos en los archivos del proyecto:

| Elemento | Configuración |
| --- | --- |
| Lenguaje del código de la app | Java |
| Compatibilidad del código Java | Java 11 |
| Diseños de pantalla | XML |
| Interfaz | Material Components y AndroidX |
| Organización de pantallas | Una actividad principal y tres fragments |
| Android mínimo | API 24 |
| Target SDK | 36 |
| Compile SDK | 36, nivel menor 1 |
| Android Gradle Plugin | 9.2.1 |
| Gradle Wrapper | 9.4.1 |
| JDK del daemon de Gradle | 21 |
| Identificador de aplicación | `com.example.componentesgrupo2` |
| Versión de la app | `1.0` |

La compatibilidad Java 11 del código y el JDK 21 que ejecuta Gradle cumplen funciones distintas dentro de la compilación.

## Organización del código

Las clases Java se encuentran en `app/src/main/java/com/example/componentesgrupo2/`.

| Clase | Responsabilidad |
| --- | --- |
| `MainActivity.java` | Configura la pantalla principal, controla la navegación, cambia los fragments y gestiona las acciones de la barra superior. |
| `CarrerasFragment.java` | Carga la pantalla de carreras y abre los detalles de las tarjetas. |
| `NoticiasFragment.java` | Carga la pantalla de noticias y abre los detalles de las publicaciones. |
| `ContactoFragment.java` | Carga la pantalla informativa de contacto. |

Los recursos visuales se encuentran en `app/src/main/res/`.

| Archivo o carpeta | Contenido |
| --- | --- |
| `layout/activity_main.xml` | Estructura principal y contenedor de las secciones. |
| `layout/fragment_carreras.xml` | Tarjetas y textos de carreras. |
| `layout/fragment_noticias.xml` | Tarjetas y textos de noticias. |
| `layout/fragment_contacto.xml` | Datos de contacto. |
| `layout/nav_header.xml` | Encabezado del menú lateral. |
| `menu/drawer_menu.xml` | Opciones del menú lateral. |
| `menu/toolbar_menu.xml` | Acciones de la barra superior. |
| `values/strings.xml` | Nombre de la app, etiquetas y mensajes compartidos. |
| `values/colors.xml` y `values/themes.xml` | Colores y tema visual. |
| `drawable/` | Imágenes, iconos y fondos. |

La configuración de la aplicación está en `app/src/main/AndroidManifest.xml` y `app/build.gradle`. Las versiones de las dependencias se centralizan en `gradle/libs.versions.toml`.

## Personalizar la plantilla

- **Nombre y mensajes:** modifica los textos de `res/values/strings.xml`, incluidos el nombre de la app, el encabezado, Acerca de y el mensaje para compartir.
- **Oferta académica:** edita las tarjetas de `fragment_carreras.xml`.
- **Noticias:** sustituye las publicaciones de `fragment_noticias.xml`.
- **Contacto:** reemplaza los datos de `fragment_contacto.xml`.
- **Identidad visual:** ajusta colores, temas, imágenes e iconos en los recursos correspondientes.
- **Nuevas secciones:** crea su diseño y fragment, añade una opción al menú y configura su selección en `MainActivity.java`.

Las cuatro tarjetas de carreras y las cuatro de noticias se conectan explícitamente desde sus clases Java. Si agregas tarjetas, también debes configurar sus eventos para que puedan abrir el detalle.

Integrar una búsqueda real, cuentas de usuario o contenido remoto requeriría desarrollar esas funciones sobre la estructura actual.
