fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer()
    timer.time = timerValue
    println(timer.time)
}

class ByteTimer {
    var time:Int = 0
        set(value) {
            field = value.coerceAtLeast(-128).coerceAtMost(127)
        }
}
