package engine.ktor.exception

import engine.ktor.response.ServerResponse
import exception.*

internal fun getException(
    error: ServerResponse.Error
): Throwable {
    return when (error.code) {
        402 -> BlitzFieldNotSpecifiedException(error.field)
        404 -> when (error.message) {
            BlitzMethodNotFoundException.MESSAGE -> BlitzMethodNotFoundException()
            else -> BlitzFieldNotFoundException(error.field)
        }
        405 -> BlitzMethodDisabledException()
        407 -> when (error.message) {
            BlitzRequestLimitExceededException.MESSAGE -> BlitzRequestLimitExceededException()
            BlitzServerInvalidIpAddressException.MESSAGE -> BlitzServerInvalidIpAddressException()
            BlitzInvalidApplicationIdException.MESSAGE -> BlitzInvalidApplicationIdException()
            BlitzApplicationBlockedException.MESSAGE -> BlitzApplicationBlockedException()

            error.field + BlitzFieldListLimitExceededException.MESSAGE ->
                BlitzFieldListLimitExceededException(error.field)

            BlitzInvalidFieldException.MESSAGE + error.field ->
                BlitzInvalidFieldException(error.field)

            else -> BlitzInternalException(error.message)
        }
        504 -> BlitzSourceNotAvailableException()
        else -> BlitzInternalException(error.message)
    }
}
