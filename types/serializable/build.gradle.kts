plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = "org.example"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
    implementation(project(":types"))
}

kotlin {
    jvmToolchain(22)
    explicitApi()
}
