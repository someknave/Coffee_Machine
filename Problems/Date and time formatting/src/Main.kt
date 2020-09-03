import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val hrs = scanner.nextInt()
    val mins = scanner.nextInt()
    val secs = scanner.nextInt()
    val day = scanner.nextInt()
    val month = scanner.nextInt()
    val year = scanner.nextInt()
    println("$hrs:$mins:$secs $day/$month/$year")
}