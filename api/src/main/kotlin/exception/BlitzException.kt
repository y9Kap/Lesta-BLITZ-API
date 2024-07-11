package exception

public sealed class BlitzException(
    message: String? = null,
    cause: Throwable? = null
) : RuntimeException(message, cause) {
    final override val cause: Throwable? get() = super.cause
    final override val message: String? get() = super.message
}
