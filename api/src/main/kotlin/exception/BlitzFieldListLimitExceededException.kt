package exception

public class BlitzFieldListLimitExceededException(
    field: String,
    cause: Throwable? = null
) : BlitzResponseException(
    code = CODE,
    message = field.uppercase() + MESSAGE,
    cause = cause
) {
    public companion object {
        public const val CODE: Int = 407
        public const val MESSAGE: String = "_LIST_LIMIT_EXCEEDED"
    }
}
