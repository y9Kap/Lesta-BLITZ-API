import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    id("io.ktor.plugin") version "2.3.12"
    id("signing")
    id("com.vanniktech.maven.publish") version "0.29.0"
}

group = "org.example"
version = "0.2.0"

repositories {
    mavenCentral()
}

tasks.named<ShadowJar>("shadowJar") {
    enabled = false
}

mavenPublishing {
    coordinates("com.example.Lesta-BLITZ-API", "Lesta-BLITZ-API", "0.2.0-SNAPSHOT")

    pom {
        name.set("Lesta-BLITZ-API")
        description.set("Library for interacting with the Lesta Games API")
        inceptionYear.set("2024")
        url.set("https://github.com/y9Kap/Lesta-BLITZ-API")
        licenses {
            license {
                name.set("The MIT License")
                url.set("https://opensource.org/licenses/MIT")
                distribution.set("https://opensource.org/licenses/MIT")
            }
        }
        developers {
            developer {
                id.set("y9Kap")
                name.set("Ivan Korolev")
                url.set("https://github.com/y9Kap/")
            }
        }
        scm {
            url.set("https://github.com/y9Kap/Lesta-BLITZ-API/")
            connection.set("scm:git:git://github.com/y9Kap/Lesta-BLITZ-API.git")
            developerConnection.set("scm:git:ssh://git@github.com/y9Kap/Lesta-BLITZ-API.git")
        }
    }
}

kotlin {
    jvmToolchain(22)
}
