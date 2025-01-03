import java.util.*

fun main() {
    val solution = Solution()
    val result = solution.isValid("()")
    println("Result $result")
}

class Solution {
    fun isValid(s: String): Boolean {

        var answer = false

        var checkString = ""
        loop@ for (i in s.indices) {
            val char = s[i]
            if (
                char == '(' ||
                char == '{' ||
                char == '['
            ) {
                checkString += char
            } else {
                if (checkString.isEmpty()) {
                    answer = false
                    break@loop
                }

                val lastChar = checkString.last()
                if (
                    char == ')' && lastChar == '(' ||
                    char == '}' && lastChar == '{' ||
                    char == ']' && lastChar == '[') {
                    answer = true
                    checkString = checkString.dropLast(1)
                } else {
                    answer = false
                    break@loop
                }
            }
        }

        if (checkString.length > 0) {
            answer = false
        }

        return answer
    }
}