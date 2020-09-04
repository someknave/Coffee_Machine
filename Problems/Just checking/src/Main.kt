import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val response = scanner.nextInt()
    print(when(response) {
        2 -> "Yes!"
        in 1..4 -> "No!"
        else -> "Unknown number"
    })
}