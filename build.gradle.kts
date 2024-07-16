import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    id("io.ktor.plugin") version "2.3.12"
    id("signing")
    id("com.vanniktech.maven.publish") version "0.29.0"
}

repositories {
    mavenCentral()
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

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()
    configure(KotlinJvm(
        javadocJar = JavadocJar.Empty(),
        sourcesJar = true,
    ))
}

mavenPublishing {
    coordinates("io.github.y9kap.Lesta-BLITZ-API", "Lesta-BLITZ-API", "0.3.3")

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

signing {
    useGpgCmd()
    sign(publishing.publications)
}

kotlin {
    jvmToolchain(22)
    explicitApi()
}
