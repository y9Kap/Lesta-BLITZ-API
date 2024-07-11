@file:OptIn(UnstableApi::class)

import annotation.UnstableApi
import engine.ktor.KtorBlitzEngine
import io.ktor.client.*
import kotlinx.serialization.json.Json
import io.ktor.client.plugins.logging.*
import url.Url
import url.url

public fun BlitzApi(
    baseUrl: Url,
    httpClient: HttpClient = HttpClient(),
    json: Json = Json
): BlitzApi = BlitzApi(
    engine = KtorBlitzEngine(
        baseUrl = baseUrl,
        httpClient = httpClient,
        json = json
    )
)

public fun BlitzApi.Companion.lestaBlitzServer(
    httpClient: HttpClient = HttpClient(),
    enableLogging: Boolean = false,
    json: Json = Json
): BlitzApi {
    val configuredClient = if (enableLogging) {
        httpClient.config {
            Logging {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
        }
    } else httpClient

    return BlitzApi(
        httpClient = configuredClient,
        json = json,
        baseUrl = "https://papi.tanksblitz.ru/wotb".url
    )
}
