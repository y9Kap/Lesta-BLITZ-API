package exception

public class BlitzNotEnoughSearchLengthException(
    cause: Throwable? = null
) : BlitzResponseException(
    code = CODE,
    message = MESSAGE,
    cause = cause
) {
    public companion object {
        public const val CODE: Int = 407
        public const val MESSAGE: String = "NOT_ENOUGH_SEARCH_LENGTH"
    }
}
