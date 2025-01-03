package codinggame

import java.util.*

fun main(args : Array<String>) {
    val input = Scanner(System.`in`)
    val size = input.nextInt()

    for (i in 0 until size) {
        val starString = StringBuilder()
        for (j in 1 until i) {
            starString.append(" ")
        }
        for (j in 0 until i) {
            starString.append("*")
        }
        println(starString)
    }
}