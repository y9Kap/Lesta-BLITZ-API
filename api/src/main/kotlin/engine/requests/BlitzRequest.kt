package engine.requests

public sealed interface BlitzRequest<out T>

public typealias SimpleBlitzRequest = BlitzRequest<Unit>
