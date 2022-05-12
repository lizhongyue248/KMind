pluginManagement {
  repositories {
    mavenCentral()
    gradlePluginPortal()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
  }

}
rootProject.name = "KMind"


include(":android")
include(":desktop")
include(":common")

