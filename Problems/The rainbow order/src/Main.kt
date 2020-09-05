import java.util.Scanner

enum class Rainbow(val color: String, val index:Int) {
    RED("red", 1),
    ORANGE("orange", 2),
    YELLOW("yellow", 3),
    GREEN("green", 4),
    BLUE("blue", 5),
    INDIGO("indigo", 6),
    VIOLET("violet", 7);

    companion object {
        fun colorToIndex(color: String): Int {
            for (enum in Rainbow.values()) {
                if (color == enum.color) {
                    return enum.index
                }
            }
            return 0
        }
    }


}

fun main() {
    val input = Scanner(System.`in`)
    val color = input.next()
    println(Rainbow.colorToIndex(color))
}
