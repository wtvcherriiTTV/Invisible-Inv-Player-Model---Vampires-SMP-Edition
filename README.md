# No Inventory Character

This mod removes the Player-Render from all the Game's Inventory Screens (Except for the Smithing Table).
This is especially useful if you use stuff like graphics in Resourcepacks, which would be obscured by the render.

### Building:

- Make sure you got both a java 25+ jdk and git installed and in your path
- Run the following commands in your favorite terminal:
- ````shell
  git clone "https://github.com/lunatic-gh/no-inv-character"
  cd "no-inv-character"
  .\gradlew build # On Windows
  ./gradle build # On Linux/MacOS
  ````
- The Built jar file will be in ``<project-directory>/build/libs/[modname]-[version].jar``
  - The file ending with ``-sources.jar`` is not the mod, but the compressed source files.
