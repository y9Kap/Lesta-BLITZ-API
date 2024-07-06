package accounts

public sealed class SearchType(val type: String) {
    data object StartsWith : SearchType("startswith")
    data object Exact : SearchType("exact")
}
