# DungeON

## Descripción

DungeON es un videojuego de rol (RPG) por turnos donde los jugadores deben enfrentar enemigos hasta llegar a un jefe final. Los jugadores pueden elegir entre diferentes clases, cada una con sus características únicas, para enfrentarse a los desafíos que el juego ofrece. Este proyecto está desarrollado en Java (JDK 21) y está diseñado para ejecutarse en la terminal.

---

## Características

- **Clases disponibles:**
  - **Guerrero:** Salud alta y daño moderado.
  - **Mago:** Salud baja y daño alto con magia.
  - **Ladrón:** Salud moderada y daño equilibrado.
- **Sistema de combate:**
  - Turnos para atacar y recibir daño.
  - Diferentes habilidades y objetos para elegir (en desarrollo).
- **Instrucciones y Créditos:**
  - Menú interactivo para acceder a las instrucciones del juego y visualizar los créditos del equipo de desarrollo.

---

## Instrucciones

1. **Inicio del juego:** Ejecuta el programa para visualizar la pantalla de bienvenida y el menú principal.
2. **Menú principal:**
   - Selecciona una opción:
     - `1`: Jugar.
     - `2`: Ver las instrucciones.
     - `3`: Ver los créditos.
     - `4`: Mostrar historial partidas.
     - `5`: Salir del juego.
3. **Selección de clase:**
   - Elige entre Guerrero, Mago o Ladrón.
   - Cada clase tiene atributos únicos de salud y daño.
4. **Combate:**
   - Realiza acciones como atacar al enemigo.
   - Los enemigos contraatacan hasta que uno de los dos quede sin salud.

---

## Cómo Ejecutar el Juego


1. Asegúrate de tener instalado [Java](https://www.java.com/).
2. Compila el proyecto desde la línea de comandos:
   ```sh
   javac -d bin src/*.java
   ```
3. Genera el archivo `.jar` ejecutable:
   ```sh
   jar cfe DungeON.jar DungeON -C bin .
   ```
4. Para ejecutar el juego en Windows, usa el siguiente comando en la terminal (cmd o PowerShell):
   ```sh
   java -jar DungeON.jar
   ```
5. Para ejecutar desde Visual Studio Code:
   ```sh
   Abre el archivo DungeON.java y pulsa Ctrl + F5
   ```

---

## Créditos

**Desarrollo:**
- Daniel Fuente (Desarrollador principal)
- Samuel Díaz (Debugger)

**Diseño de personajes:**
- Jean Pierre Haro
- Daniel Fuente

**Testers:**
- Consuelo Parra
- Guillermo Sierra
- Adrián Sánchez

---


## Estructura del proyecto
* Nota: la estructura del proyecto sigue en desarrollo y puede cambiar en futuras versiones.

La estructura del proyecto en Visual Studio Code es la siguiente:

```
VIDEOJUEGO
├── .vscode
├── bin
├── src
│   ├── Clases
│   │   ├── Guerrero
│   │   │   ├── Guerrero.java
│   │   │   ├── Caballero.java
│   │   ├── Ladron
│   │   │   ├── Ladron.java
│   │   ├── Mago
│   │   │   ├── Mago.java
│   ├── Mensajes
│   │   ├── Creditos.java
│   │   ├── Instrucciones.java
│   │   ├── MensajeBienvenida.java
│   │   ├── MensajeDerrota.java
│   ├── Personajes
│   │   ├── Enemigo.java
│   │   ├── Personaje.java
│   ├── Utilidades
│   │   ├── Utils.java
│   ├── DungeON.java
├── DungeON.jar
└── README.md

```

---

## Notas Adicionales

- **Estado del proyecto:**
  - Algunas funcionalidades como habilidades y objetos están en desarrollo (marcadas como "WIP").
- **Colaboraciones:** Si tienes sugerencias o deseas contribuir al proyecto, no dudes en contactarnos.
