@file:Suppress("UnstableApiUsage")

import org.jetbrains.compose.compose

plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose") version "1.1.1"
  id("com.android.library")
}

group = "wiki.zyue.kmind"
version = "1.0"

kotlin {
  android()
  jvm("desktop") {
    compilations.all {
      kotlinOptions.jvmTarget = "17"
    }
  }
  sourceSets {
    named("commonMain") {
      dependencies {
        api(compose.runtime)
        api(compose.foundation)
        api(compose.material)
      }
    }
    named("commonTest") {
      dependencies {
        implementation(kotlin("test"))
      }
    }
    named("androidMain") {
      dependencies {
        api("androidx.appcompat:appcompat:1.4.1")
        api("androidx.core:core-ktx:1.7.0")
      }
    }
    named("androidTest") {
      dependencies {
        implementation("junit:junit:4.13.2")
      }
    }
    named("desktopMain") {
      dependencies {
        api(compose.preview)
      }
    }
    named("desktopTest") {
      dependencies {
      }
    }
  }
}

android {
  compileSdk = 31
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
  defaultConfig {
    minSdk = 24
    targetSdk = 31
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
}