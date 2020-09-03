import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val x1 = scanner.nextInt()
    val y1 = scanner.nextInt()
    val z1 = scanner.nextInt()
    val x2 = scanner.nextInt()
    val y2 = scanner.nextInt()
    val z2 = scanner.nextInt()
    val first = listOf(x1, y1, z1).sorted()
    val second = listOf(x2, y2, z2).sorted()
    var state = 0
    for (i in first.indices) {
        when {
            first[i] < second[i] -> state = state or 1
            first[i] > second[i] -> state = state or 2
        }
    }
    when (state) {
        0 -> println("Box 1 = Box 2")
        1 -> println("Box 1 < Box 2")
        2 -> println("Box 1 > Box 2")
        else -> println("Incomparable")
    }


}