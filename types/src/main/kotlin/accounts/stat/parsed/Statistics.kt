package accounts.stat.parsed

public data class Statistics(
    val clan: Analytics,
    val all: Analytics,
    val frags: Map<String, Int>?,
    val rating: Rating?
)
