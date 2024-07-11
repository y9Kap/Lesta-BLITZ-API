package exception

public class BlitzInternalException(
    message: String = "Unknown exception occurred. Please do not try the request with these parameters again",
    cause: Throwable? = null
) : BlitzException(message, cause)
