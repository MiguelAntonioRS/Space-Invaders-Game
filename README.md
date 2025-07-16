# Space Ship Game

## Description

Space Ship Game is a 2D space shooter game developed in Java. Players can navigate their spaceship and face different challenges as they progress through various game states, including a main menu, a loading state, and a high scores screen.

## Requirements

    Java JDK 17 or higher
    Maven (optional, for dependency management)
    An IDE (e.g., IntelliJ IDEA, Eclipse)

### Installation

  Clone the repository: 
```bash
git clone https://github.com/MiguelAntonioRS/Space-Invaders-Game.git
cd space-ship-game
```
### Compile the project:

Make sure the JDK is configured in your PATH. 
```
javac -d bin src/com/spaceGameShip/*.java src/com/spaceGameShip/Graphics/*.java src/com/spaceGameShip/State/*.java src/com/spaceGameShip/ui/*.java src/com/spaceGameShip/input/*.java src/com/spaceGameShip/math/*.java src/com/spaceGameShip/io/*.java src/com/spaceGameShip/gameObject/*.java
```
If you're using Maven, simply run:
```
mvn clean install
```

### Run the game:
```
java -cp bin com.spaceGameShip.Main
```

### Project Structure

* src/com/spaceGameShip/: Contains the main game classes.
* Main.java: Main class that starts the game.
* States/: Contains the classes representing different game states.
* Graphics/: Manages graphics and text loading.
* ui/: Contains the Button class and Action interface.
* input/: Handles keyboard and mouse input.
* math/: Auxiliary math classes.
* io/: Handles data input/output (e.g., scores).
* gameObject/: Defines game constants and objects.

### Controls

 * Arrow Keys: Move the spaceship.
 * P: Shoot.

### Contributions

Contributions are welcome. Please open an issue or submit a pull request to collaborate on the project.
