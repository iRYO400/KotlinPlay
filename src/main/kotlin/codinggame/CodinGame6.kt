package codinggame

import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val N = input.nextInt()
    if (input.hasNextLine()) {
        input.nextLine()
    }

    val result = StringBuilder()
    for (i in 0 until N) {
        val LINE = input.nextLine()

        val binary = StringBuilder()
        for (j in LINE.indices) {
            val bit = LINE[j]
            if (bit == '-') {
                binary.append("1")
            } else if (bit == '_') {
                binary.append("0")
            }
        }

        val charCode = binary.toString().toInt(2)

        val char = Char(charCode)
        result.append(char)
    }


    // Write an answer using println()
    // To debug: System.err.println("Debug messages...");

    println(result.toString())
}