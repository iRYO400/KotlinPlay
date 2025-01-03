package codinggame

import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val n = input.nextInt()
    if (input.hasNextLine()) {
        input.nextLine()
    }
    val k = input.nextLine()
    var score = 0
    loop@ for (i in 0 until n) {
        val a = input.nextLine()
        var doubleAnswerCount = 0
        var xIndex = Int.MAX_VALUE
        for (j in a.indices) {
            if (a[j] == 'X') {
                xIndex = j
                doubleAnswerCount++
            }
            if (doubleAnswerCount > 1) {
                continue@loop
            }
        }

        val kIndex = when (k[i]) {
            'A' -> 0
            'B' -> 1
            'C' -> 2
            'D' -> 3
            'E' -> 4
            else -> Int.MAX_VALUE
        }

        if (xIndex != Int.MAX_VALUE && xIndex == kIndex) {
            score += 20
        }
    }

    println(score)
}