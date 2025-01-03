package leetcode

fun main() {

    println(isPalindrome("race a car"))
}

fun isPalindrome(s: String): Boolean {
    val result = StringBuilder()


    val digits = 48..57
    val alphabet = 97..122
    for (i in s.indices) {
        val char = Character.toLowerCase(s[i])
        if (char.toInt() in digits || char.toInt() in alphabet) {
            result.append(char)
        }
    }
    return result.toString() == result.reverse().toString()
}