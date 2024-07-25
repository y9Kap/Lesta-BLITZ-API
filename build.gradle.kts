import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    id("io.ktor.plugin") version "2.3.12"
    id("org.gradle.maven-publish")
}

repositories {
    mavenCentral()
}
group = "io.github.y9Kap"

publishing {
    repositories {
        maven {
            name = "Lesta-BLITZ-API"
            url = uri("https://maven.pkg.github.com/y9Kap/Lesta-BLITZ-API")
            credentials {
                username = System.getenv("GITHUB_USERNAME")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }

    publications.withType<MavenPublication> {
        version = "0.0.1"
    }
}

val ktorVersion = "2.3.12"

tasks.named<ShadowJar>("shadowJar") {
    enabled = false
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
    implementation(project(":api:api-ktor"))
}


kotlin {
    jvmToolchain(22)
    explicitApi()
}
