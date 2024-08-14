package accounts

public sealed class SearchType(public val type: String) {
    public data object StartsWith : SearchType("startswith")
    public data object Exact : SearchType("exact")
}
