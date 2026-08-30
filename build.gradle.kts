plugins {
  id("net.fabricmc.fabric-loom-remap") version "1.16.3"
}

val modVersion: String = "1.2.0+build.1"
val minecraftVersion: String = "1.21.10"

dependencies {
  minecraft("com.mojang:minecraft:$minecraftVersion")
  
  // Updated Yarn mappings specifically for 1.21.10
  mappings("net.fabricmc:yarn:1.21.10+build.1:v2")
  
  modImplementation("net.fabricmc:fabric-loader:0.18.1")
  modImplementation("net.fabricmc.fabric-api:fabric-api:0.138.3+1.21.10")
}

tasks.processResources {
  filesMatching("fabric.mod.json") {
    expand(mapOf("version" to modVersion))
  }
}

tasks.withType<JavaCompile>().configureEach {
  options.release.set(21)
}

java {
  withSourcesJar()
  sourceCompatibility = JavaVersion.VERSION_21
  targetCompatibility = JavaVersion.VERSION_21
}