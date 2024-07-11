package exception

public class BlitzSourceNotAvailableException(
    cause: Throwable? = null
) : BlitzResponseException(
    code = CODE,
    message = MESSAGE,
    cause = cause
) {
    public companion object {
        public const val CODE: Int = 504
        public const val MESSAGE: String = "SOURCE_NOT_AVAILABLE"
    }
}
