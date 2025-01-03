import java.util.*

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val height = input.nextInt()
    val width = input.nextInt()

    // Write an answer using println()
    // To debug: System.err.println("Debug messages...");

    val string = StringBuilder()
    for (i in 0 until height) {
        for (j in 0 until width) {
            string.append("O")
        }
        if (i != height - 1)
            string.appendln()
    }

    println(string.trim())
}