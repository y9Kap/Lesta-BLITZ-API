@file:OptIn(UnsafeConstructor::class, UnstableApi::class)

package url

import annotation.UnsafeConstructor
import annotation.UnstableApi
import kotlin.jvm.JvmInline

@UnstableApi
@JvmInline
public value class Url @UnsafeConstructor constructor(public val string: String) {
    public operator fun div(url: Url): Url {
        val base = string.trimEnd('/')
        val additional = url.string.trimStart('/')
        val combined = "$base/$additional/"
        return Url(combined)
    }

    public operator fun div(string: String): Url = this / Url(string)

    public operator fun plus(parameters: Parameters): Url {
        val string = buildString {
            append(string)

            for ((key, value) in parameters.map.entries) {
                if (string.contains('?')) {
                    append("&")
                } else {
                    append("?")
                }
                append(encodeQueryParam(key))
                append("=")
                append(encodeQueryParam(value))
            }
        }
        return Url(string)
    }

    public companion object {
        private val REGEX = Regex("(.+)://(.+)")

        public fun parseOrNull(string: String): Url? {
            if (!string.matches(REGEX)) {
                return null
            }
            return Url(string)
        }

        public fun parse(string: String): Url = parseOrNull(string)
            ?: error("Url '$string' does not match URL predicate")
    }
}

public val String.url: Url get() = Url.parse(string = this)
public val String.urlOrNull: Url? get() = Url.parseOrNull(string = this)

private fun encodeQueryParam(value: String): String = buildString {
    val allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-._~"
    val utf8Bytes = value.encodeToByteArray()

    for (byte in utf8Bytes) {
        val char = byte.toInt().toChar()
        if (char in allowedChars) {
            append(char)
        } else {
            append('%')
            append(
                byte.toUByte()
                    .toString(radix = 16)
                    .padStart(length = 2, padChar = '0')
            )
        }
    }
}
