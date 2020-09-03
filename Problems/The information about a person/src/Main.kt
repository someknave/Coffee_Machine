import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val fName = scanner.next()
    val lName = scanner.next()
    val age = scanner.nextInt()
    println("${fName.first()}. $lName, $age years old")
}