package exception

public open class BlitzResponseException(
    public val code: Int,
    message: String, cause: Throwable?
) : BlitzException(message, cause)
