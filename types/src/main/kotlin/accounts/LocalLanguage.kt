package accounts

public sealed class LocalLanguage(public val type: String) {
    public data object English : LocalLanguage("en")
    public data object Russian : LocalLanguage("ru")
    public data object Polish : LocalLanguage("pl")
    public data object German : LocalLanguage("de")
    public data object French : LocalLanguage("fr")
    public data object Spanish : LocalLanguage("es")
    public data object SimplifiedChinese : LocalLanguage("zh-cn")
    public data object TraditionalChinese : LocalLanguage("zh-tw")
    public data object Turkish : LocalLanguage("tr")
    public data object Czech : LocalLanguage("cs")
    public data object Thai : LocalLanguage("th")
    public data object Vietnamese : LocalLanguage("vi")
    public data object Korean : LocalLanguage("ko")
}
