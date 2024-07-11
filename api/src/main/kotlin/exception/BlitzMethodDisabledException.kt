package exception

public class BlitzMethodDisabledException(
    message: String = "METHOD_DISABLED",
    cause: Throwable? = null
) : BlitzResponseException(
    code = CODE,
    message = message,
    cause = cause
) {
    public companion object {
        public const val CODE: Int = 405
    }
}
