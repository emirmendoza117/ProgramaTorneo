# ProgramaTorneo

Programa de escritorio desarrollado en Java con Swing para registrar equipos en el torneo **Arena Masters**. Permite administrar hasta 10 inscripciones, calcular el costo de cada equipo y consultar o modificar su estado de pago.

## Características

- Inicio de sesión con el nombre del organizador.
- Pantalla de términos y condiciones antes de ingresar.
- Registro de equipos con:
  - Nombre del equipo.
  - Nombre y correo del capitán.
  - Videojuego.
  - Plataforma.
  - Cantidad de integrantes.
- Selección de hasta 10 integrantes por equipo.
- Clasificación automática:
  - Individual: 1 integrante.
  - Equipo: 2 a 5 integrantes.
  - Profesional: 6 a 10 integrantes.
- Cálculo automático de precio base, cargos adicionales y descuentos.
- Consulta de todos los registros almacenados durante la sesión.
- Cambio del estado de pago de cada equipo.
- Tema blanco, azul, verde y predeterminado.
- Información del torneo y de la aplicación.
- Acciones para limpiar el formulario, reiniciar registros, cerrar sesión o salir.

## Flujo de uso

1. Ejecuta `Login.java`, `Programa.jar` o el lanzamiento disponible en el proyecto.
2. Introduce el nombre del organizador.
3. Acepta los términos y condiciones.
4. Completa el formulario principal.
5. Selecciona **Registrar**.
6. Abre **Operaciones > Base de Datos** para consultar una inscripción.
7. Usa **Estados Pagos** para cambiar el estado del equipo seleccionado.

## Videojuegos y plataformas

Videojuegos disponibles:

- Minecraft
- Valorant
- Fortnite
- Roblox

Plataformas disponibles:

- PC
- Xbox
- PlayStation
- Nintendo Switch

Los recursos gráficos utilizados por la interfaz se encuentran en la carpeta `images/`.

## Cálculo de inscripción

| Tipo | Integrantes | Precio base | Cargo adicional |
|---|---:|---:|---|
| Individual | 1 | $100 | Sin cargo |
| Equipo | 2 a 5 | $350 | $50 por integrante adicional, desde el segundo |
| Profesional | 6 a 10 | $800 | $75 por integrante adicional, desde el sexto |

Las reglas de descuento son:

- Equipos profesionales: 10 % sobre el total sin descuentos.
- Minecraft: descuento adicional de $50.

Los equipos registrados comienzan con el estado **Pendiente de pago**.

Estados disponibles:

- Pendiente de pago
- Inscripción aceptada
- Pago confirmado
- Registro cancelado

## Requisitos

- Java JDK 11 o posterior.
- Entorno gráfico compatible con Java Swing.
- Archivos de `images/` disponibles junto a las fuentes o dentro del JAR.

## Ejecutar desde el código

Desde la raíz del proyecto:

```powershell
javac Login.java Licencia.java Principal.java Info.java EstadoPagos.java
java Login
```

El proyecto también puede abrirse y ejecutarse desde IntelliJ IDEA, Eclipse o Apache NetBeans. Configura `Login` como clase principal.

## Ejecutar el JAR

Si Java está configurado correctamente en las variables de entorno:

```powershell
java -jar Programa.jar
```

También puedes crear un nuevo JAR con el siguiente manifiesto, que debe incluir `Main-Class: Login`:

```text
Manifest-Version: 2.0
Created-By: Emir Mendoza
Main-Class: Login
X-COMMENT: Proyecto Mini Interfaz
```

## Almacenamiento

Los registros se mantienen temporalmente en la matriz `Principal.Datos` mientras la aplicación está abierta.

- **Nuevo:** limpia los campos sin borrar los registros.
- **Reiniciar:** elimina los registros almacenados y restablece el contador.
- **Cerrar sesión:** vuelve a la pantalla de inicio y puede cerrarse la información abierta.

No existe almacenamiento persistente en archivos ni bases de datos. Los datos se pierden al cerrar por completo la aplicación.

## Tecnologías

- Java
- Java Swing
- Java AWT
- Sin dependencias externas ni gestor de compilación

## Estructura del proyecto

```text
ProgramaTorneo/
├── Login.java
├── Licencia.java
├── Principal.java
├── Info.java
├── EstadoPagos.java
├── Programa.jar
├── MANIFEST.MF
├── README.md
├── images/
│   ├── logo.png
│   ├── control.png
│   ├── minecraft.png
│   ├── valorant.png
│   ├── fortnite.jpg
│   └── roblox.png
└── releases/
    └── ProgramaTorneo.rar
```

También se incluyen los archivos `.class` compilados en la raíz del proyecto.

## Autor

Emir Mendoza.
