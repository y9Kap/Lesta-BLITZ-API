plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = "org.example"

val ktorVersion = "2.3.12"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))
    implementation(project(":types"))
    implementation(project(":types:serializable"))
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
}

kotlin {
    jvmToolchain(22)
    explicitApi()
}
