import java.util.Scanner

enum class Country(val currency: String) {
    Germany("Euro"),
    Mali("CFA franc"),
    Dominica("Eastern Caribbean dollar"),
    Canada("Canadian dollar"),
    Spain("Euro"),
    Australia("Australian dollar"),
    Brazil("Brazilian real"),
    Senegal("CFA franc"),
    France("Euro"),
    Grenada("Eastern Caribbean dollar"),
    Kiribati("Australian dollar");

    companion object {
        fun getCurrency(name: String): String? {
            for (enum in Country.values()) {
                if (name == enum.name) return enum.currency
            }
            return null
        }
        fun sameCurrency(name1: String, name2: String): Boolean {
            val curr1 = getCurrency(name1)
            val curr2 = getCurrency(name2)
            return when {
                curr1.isNullOrEmpty() || curr2.isNullOrEmpty() -> false
                else -> curr1 == curr2
            }
        }
    }

}

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val country1 = input.next()
    val country2 = input.next()
    println(Country.sameCurrency(country1, country2))
}