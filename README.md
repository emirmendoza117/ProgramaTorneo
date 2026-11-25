# ProgramaTorneo

Aplicación de escritorio desarrollada en Java con Swing para registrar hasta 10 equipos participantes en un torneo de videojuegos.

![Java](https://img.shields.io/badge/Java-100%25-orange)

## Características

- Inicio de sesión con el nombre del organizador.
- Confirmación de términos y condiciones antes de acceder.
- Registro de equipos con:
  - Nombre del equipo.
  - Nombre y correo del capitán.
  - Videojuego seleccionado.
  - Plataforma de juego.
  - Cantidad de integrantes, desde 1 hasta 10.
- Clasificación automática del equipo:
  - **Individual:** 1 integrante.
  - **Equipo:** de 2 a 5 integrantes.
  - **Profesional:** de 6 a 10 integrantes.
- Cálculo de precio base, costo adicional por integrantes y descuentos.
- Consulta de la información de cada inscripción desde **Operaciones > Base de Datos**.
- Cambio de tema entre blanco, azul, verde y el tema predeterminado.
- Imágenes asociadas a Minecraft, Valorant, Fortnite y Roblox.
- Opciones para limpiar el formulario, reiniciar los registros, cerrar sesión o salir.

## Tecnologías

- Java.
- Java Swing.
- Java AWT.
- No utiliza dependencias externas ni gestor de compilación.

## Requisitos

- Java JDK 8 o una versión posterior.
- Un entorno compatible con aplicaciones gráficas Java Swing.

## Ejecución

Desde la raíz del proyecto, compila las clases y ejecuta `Login`:

```bash
javac Login.java Licencia.java Principal.java Info.java
java Login
```

También puedes abrir el proyecto en IntelliJ IDEA, Eclipse o Apache NetBeans y ejecutar `Login.java` como clase principal.

> La carpeta `images/` debe permanecer junto a los archivos `.java` o `.class`, ya que la aplicación carga sus recursos mediante rutas relativas.

## Uso

1. Ejecuta la aplicación.
2. Introduce el nombre del organizador.
3. Acepta los términos y condiciones.
4. Completa todos los campos del formulario.
5. Presiona **Registrar**.
6. Selecciona **Operaciones > Base de Datos** para consultar una inscripción.

El programa permite consultar los registros numerados del 1 al 10 en la ventana de información.

## Cálculo de inscripción

| Tipo | Integrantes | Precio base | Precio adicional |
|---|---:|---:|---|
| Individual | 1 | $100 | Sin costo adicional |
| Equipo | 2–5 | $350 | $50 por integrante adicional a partir del segundo |
| Profesional | 6–10 | $800 | $75 por integrante adicional a partir del sexto |

Los equipos profesionales reciben un descuento del 10 %. Además, las inscripciones de Minecraft incluyen un descuento adicional de $50. Todos los registros comienzan con el estado **Pendiente de pago**.

## Almacenamiento

Los datos se conservan temporalmente en la matriz estática `Principal.Datos` durante la ejecución del programa.

- **Nuevo:** limpia el formulario sin borrar los registros.
- **Reiniciar:** elimina todos los registros almacenados.
- **Cerrar sesión:** vuelve a la pantalla de inicio.

Al cerrar la aplicación, los datos no se conservan porque no existe persistencia en archivos o bases de datos.

## Estructura del proyecto

```text
ProgramaTorneo/
├── Login.java       # Inicio de sesión del organizador
├── Licencia.java    # Términos y condiciones
├── Principal.java   # Formulario, registros y menú principal
├── Info.java        # Consulta de inscripciones
├── README.md        # Documentación del proyecto
└── images/
    ├── logo.png
    ├── control.png
    ├── minecraft.png
    ├── valorant.png
    ├── fortnite.jpg
    └── roblox.png
```

## Capturas

Las imágenes utilizadas por la interfaz se encuentran en la carpeta `images/`.

## Autor

Desarrollado por Emir Mendoza.
