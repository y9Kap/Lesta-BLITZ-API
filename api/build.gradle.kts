plugins {
    kotlin("jvm")
}

group = "org.example"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":types"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
}

kotlin {
    jvmToolchain(22)
}
