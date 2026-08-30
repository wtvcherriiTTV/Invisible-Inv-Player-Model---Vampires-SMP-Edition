# Invisible Inv Player Model - Vampires SMP Edition

This mod removes the Player-Render from all the Game's Inventory Screens (Except for the Smithing Table).
This is especially useful if you use stuff like graphics in Resourcepacks, which would be obscured by the render.
This can also be toggled with a set keybind (default is P), armour will still be visible in the inventory menu, even if the Player-Render is not.

### Building:

- Make sure you got both a java 21+ jdk and git installed and in your path
- Run the following commands in your favorite terminal:
- ````shell
  git clone "https://github.com/lunatic-gh/no-inv-character](https://github.com/wtvcherriiTTV/Invisible-Inv-Player-Model---Vampires-SMP-Edition"
  cd "Invisible-Inv-Player-Model---Vampires-SMP-Edition"
  .\gradlew build # On Windows
  ./gradle build # On Linux/MacOS
  ````
- The Built jar file will be in ``<project-directory>/build/libs/[modname]-[version].jar``
  - The file ending with ``-sources.jar`` is not the mod, but the compressed source files.
