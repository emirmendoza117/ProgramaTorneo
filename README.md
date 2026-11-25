# ProgramaTorneo

Aplicación de escritorio escrita en Java para registrar equipos que participan en un torneo de videojuegos y consultar la información de cada inscripción.

## Características

- Inicio de sesión del organizador mediante nombre de administrador.
- Validación y aceptación de términos y condiciones.
- Registro de hasta 10 equipos con:
  - Nombre del equipo.
  - Nombre y correo del capitán.
  - Videojuego.
  - Plataforma.
  - Cantidad de integrantes.
- Clasificación automática de la inscripción:
  - **Individual:** 1 integrante.
  - **Equipo:** de 2 a 5 integrantes.
  - **Profesional:** de 6 a 10 integrantes.
- Consulta de los registros desde la ventana de información.
- Cambio de tema entre blanco, azul, verde y predeterminado.
- Imágenes correspondientes a Minecraft, Valorant, Fortnite y Roblox.

## Tecnologías

- Java.
- Java Swing.
- AWT.
- Sin dependencias externas ni gestor de compilación configurado.

## Requisitos

- Java JDK 8 o superior.
- Entorno que permita ejecutar aplicaciones gráficas Java Swing.

## Ejecución

Desde la raíz del proyecto:

```bash
javac Login.java Licencia.java Principal.java Info.java
java Login
```

Es importante mantener la carpeta `images/` junto a los archivos `.class`, ya que el programa carga los recursos desde rutas relativas.

También puede abrir el proyecto en un IDE compatible con Java, como IntelliJ IDEA, Eclipse o Apache NetBeans, y ejecutar la clase `Login` como punto de entrada.

## Flujo de uso

1. Ejecutar `Login.java`.
2. Ingresar el nombre del organizador.
3. Aceptar los términos y condiciones.
4. Completar el formulario de inscripción.
5. Pulsar **Registrar**.
6. Abrir **Operaciones > Base de Datos** para consultar los equipos registrados.

## Estructura del proyecto

```text
ProgramaTorneo/
├── Login.java       # Pantalla inicial e ingreso del administrador
├── Licencia.java    # Términos y condiciones
├── Principal.java   # Registro de equipos y menú principal
├── Info.java        # Consulta de registros existentes
└── images/          # Recursos gráficos de la interfaz
```

## Almacenamiento

Los registros se almacenan únicamente en el arreglo estático `Principal.Datos` durante la ejecución del programa. Al cerrar la aplicación o usar la opción **Nuevo**, la información se elimina y no se persiste en archivos o bases de datos.

## Autor

Desarrollado por Emir Mendoza.