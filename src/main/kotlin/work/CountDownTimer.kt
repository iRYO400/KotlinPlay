package work

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.*

fun main() {
    val targetTime = 1681228379000
    val calendar = Calendar.getInstance(Locale.getDefault()).apply {
        time = Date(targetTime)
    }

    println("Target time:")
    println("${calendar.get(Calendar.HOUR_OF_DAY)} : ${calendar.get(Calendar.MINUTE)} : ${calendar.get(Calendar.SECOND)} : ${calendar.get(Calendar.DAY_OF_MONTH)}")

    var counter = 1000

    val deadline = calendar.timeInMillis
    println("deadline $deadline")
    println("current time ${System.currentTimeMillis()}")

    runBlocking {
        while (counter > 0) {
            delay(1000)

            val remaining = deadline - System.currentTimeMillis()
            println(remaining)

            calendar.timeInMillis = remaining

            println(
                "Current Time - ${calendar.get(Calendar.HOUR_OF_DAY)} : ${calendar.get(Calendar.MINUTE)} : ${calendar.get(Calendar.SECOND)}"
            )
            counter--
        }
    }
}