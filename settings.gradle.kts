plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "Lesta-BLITZ-API"
include("api")
include("api:api-ktor")
findProject(":api:api-ktor")?.name = "api-ktor"
include("types")
include("types:serializable")
findProject(":types:serializable")?.name = "serializable"
