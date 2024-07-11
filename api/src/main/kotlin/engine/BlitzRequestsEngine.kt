package engine

import engine.requests.BlitzRequest

public interface BlitzRequestsEngine {
    public suspend fun <T> execute(request: BlitzRequest<T>): T
}
