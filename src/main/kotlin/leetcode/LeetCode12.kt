package leetcode// https://leetcode.com/problems/longest-substring-without-repeating-characters
import kotlin.math.max

fun main() {

    println(lengthOfLongestSubstring("powwkeilmn"))
}

fun lengthOfLongestSubstring(s: String): Int {
    var result = 0
    val set = hashSetOf<Char>()
    var l = 0

    for (r in s.indices) {
        val newChar = s[r]

        while (set.contains(newChar)) {
            val oldChar = s[l]
            set.remove(oldChar)
            l++
        }
        set.add(newChar)
        result = max(result, set.size)
    }

    return result
}