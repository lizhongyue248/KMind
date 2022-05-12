@file:Suppress("UnstableApiUsage")

plugins {
  id("org.jetbrains.compose") version "1.1.1"
  id("com.android.application")
  kotlin("android")
}

group = "wiki.zyue.kmind"
version = "1.0"

repositories {
  mavenCentral()
  google()
}

dependencies {
  implementation(project(":common"))
  implementation("androidx.activity:activity-compose:1.4.0")
}

android {
  compileSdk = 31
  defaultConfig {
    applicationId = "me.administrator.android"
    minSdk = 24
    targetSdk = 31
    versionCode = 1
    versionName = "1.0"
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
    }
  }
}