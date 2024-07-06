package accounts

public sealed class LocalLanguage(val type: String) {
    data object English : SearchType("en")
    data object Russian : SearchType("ru")
    data object Polish : SearchType("pl")
    data object German : SearchType("de")
    data object French : SearchType("fr")
    data object Spanish : SearchType("es")
    data object SimplifiedChinese : SearchType("zh-cn")
    data object TraditionalChinese : SearchType("zh-tw")
    data object Turkish : SearchType("tr")
    data object Czech : SearchType("cs")
    data object Thai : SearchType("th")
    data object Vietnamese : SearchType("vi")
    data object Korean : SearchType("ko")
}
