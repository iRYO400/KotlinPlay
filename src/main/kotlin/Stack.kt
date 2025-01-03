import kotlin.math.max
import kotlin.math.min

fun main() {
    val buildings = intArrayOf(18, 14, 13, 16, 12)

    findBuildings(buildings).forEach {
        print("$it, ")
    }

    println("20. Valid Parentheses: ${isValid("()")}")

    println(min(2147483646, Int.MAX_VALUE))
    println(max(2147483646, Int.MAX_VALUE))
}

private fun findBuildings(buildings: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    buildings.forEachIndexed { index, height ->
        while (stack.isNotEmpty() && height >= buildings[stack.last()]) {
            stack.removeLast()
        }
        stack.addLast(index)
    }

    return stack.toIntArray()
}

private fun isValid(s: String): Boolean {
    val brackets = mapOf(')' to '(', '}' to '{', ']' to '[')
    val stack = ArrayDeque<Char>()

    for (char in s) {
        when {
            char in brackets.values -> stack.addLast(char)
            char in brackets.keys -> {
                if (stack.isEmpty() || stack.removeLast() != brackets[char]) {
                    return false
                }
            }
            else -> return false
        }
    }

    return stack.isEmpty()
}
