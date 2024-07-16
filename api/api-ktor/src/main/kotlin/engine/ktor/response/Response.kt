package engine.ktor.response

import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.statement.*
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable(with = ServerResponse.Serializer::class)
internal sealed interface ServerResponse<out T> {

    @Serializable
    data class Error(
        val field: String,
        val message: String,
        val code: Int,
        val value: String
    ) : ServerResponse<Nothing>

    @Serializable
    private data class Meta(
        val count: Int
    )

    data class Success<T>(val data: T) : ServerResponse<T>

    @Suppress("UNCHECKED_CAST")
    class Serializer<T>(subSerializer: KSerializer<T>) : KSerializer<ServerResponse<T>> {
        private val baseSerializer = Data.serializer(subSerializer)
        override val descriptor = baseSerializer.descriptor

        override fun deserialize(decoder: Decoder): ServerResponse<T> {
            val result = baseSerializer.deserialize(decoder)
            return if (result.status == "ok") {
                Success(result.data as T)
            } else {
                Error(result.error!!.field, result.error.message, result.error.code, result.error.value)
            }
        }

        override fun serialize(encoder: Encoder, value: ServerResponse<T>) {
            val data = when (value) {
                is Success -> Data(
                    status = "ok",
                    data = value.data
                )
                is Error -> Data(
                    status = "error",
                    error = Error(
                        field = value.field,
                        message = value.message,
                        code = value.code,
                        value = value.value
                    )
                )
            }
            baseSerializer.serialize(encoder, data)
        }

        @Serializable
        private data class Data<T>(
            val status: String,
            val meta: Meta? = null,
            val data: T? = null,
            val error: Error? = null
        )

    }
}

internal suspend inline fun <reified T : Any> HttpResponse.bodyAsSuccess(): T {
    when (val body = body<ServerResponse<T>>()) {
        is ServerResponse.Success -> return body.data
        is ServerResponse.Error -> throw ResponseException(this, this.bodyAsText())
    }
}
