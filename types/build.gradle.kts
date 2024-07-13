plugins {
    kotlin("jvm")
}

group = "org.example"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")
}

kotlin {
    jvmToolchain(22)
}
