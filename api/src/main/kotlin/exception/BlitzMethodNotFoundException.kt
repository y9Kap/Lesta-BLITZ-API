package exception

public class BlitzMethodNotFoundException(
    cause: Throwable? = null
) : BlitzResponseException(
    code = CODE,
    message = MESSAGE,
    cause = cause
) {
    public companion object {
        public const val CODE: Int = 404
        public const val MESSAGE: String = "METHOD_NOT_FOUND"
    }
}
