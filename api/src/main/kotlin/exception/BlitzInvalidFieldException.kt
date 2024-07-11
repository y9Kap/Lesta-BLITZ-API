package exception

public class BlitzInvalidFieldException(
    field: String,
    cause: Throwable? = null
) : BlitzResponseException(
    code = CODE,
    message = MESSAGE + field.uppercase(),
    cause = cause
) {
    public companion object {
        public const val CODE: Int = 407
        public const val MESSAGE: String = "INVALID_"
    }
}
