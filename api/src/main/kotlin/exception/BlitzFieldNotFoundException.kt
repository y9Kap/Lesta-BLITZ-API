package exception

public class BlitzFieldNotFoundException(
    field: String,
    cause: Throwable? = null
) : BlitzResponseException(
    code = CODE,
    message = field.uppercase() + MESSAGE,
    cause = cause
) {
    public companion object {
        public const val CODE: Int = 404
        public const val MESSAGE: String = "_NOT_FOUND"
    }
}
