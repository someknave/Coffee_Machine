import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var number = scanner.nextInt()
    while (number > 1) {
        print("$number ")
        when (number % 2) {
            0 -> number /= 2
            else -> number = number * 3 + 1
        }

    }
    print("$number")
}
