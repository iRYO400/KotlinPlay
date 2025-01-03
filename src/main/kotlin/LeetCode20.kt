fun main() {

    println(nextGreaterElement(321)) //124651
Int.MAX_VALUE
//    nextGreaterElement(124651)
}

private fun nextGreaterElement(n: Int): Int {
    var result = -1
    val stack = ArrayDeque<Int>()

    val string = kotlin.text.StringBuilder(n.toString())

    var idx = string.length - 1
    loop@ while (idx > 0) {
        val digit = string[idx]

        while (stack.isNotEmpty() && digit < string[stack.last()]) {
            break@loop
        }
        stack.addLast(idx)
        idx--
    }

    while (stack.isNotEmpty()) {
        if (string[idx] < string[stack.first()]) {
            val digit = string[idx]
            string.setCharAt(idx, string[stack.first()])
            string.setCharAt(stack.first(), digit)

            val head = string.substring(0, idx + 1)
            val tail = string.substring(idx + 1).reversed()

            result = try {
                "$head$tail".toInt()
            } catch (e: Exception) {
                -1
            }
            break
        } else {
            stack.removeFirst()
        }
    }

    if (result == n)
        result = -1

    return result
}

private fun nextGreaterElement2(n: Int) {
    val string = StringBuilder(n)


    var idx = string.length - 1
    while (idx > 0) {
        val rightDigit = string[idx]
        val leftDigit = string[idx - 1]

        if (rightDigit.toInt() > leftDigit.toInt()) {
            string.setCharAt(idx - 1, rightDigit)
            string.setCharAt(idx, leftDigit)

            val head = string.substring(0, idx + 1)
            val tail = string.substring(idx + 1).reversed()
            println("$head$tail".toInt())
            break
        }
        idx--
    }
}
