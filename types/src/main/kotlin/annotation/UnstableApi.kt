package annotation

@RequiresOptIn(
    message = "This api is unstable and may be removed/modified in the future",
    level = RequiresOptIn.Level.WARNING
)
public annotation class UnstableApi
