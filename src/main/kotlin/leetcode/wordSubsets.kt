package leetcode

import kotlin.math.max

fun main() {

    println("wordSubsets " + wordSubsets(arrayOf("amazon","apple","facebook","google","leetcode"), arrayOf("e", "o")))
}

private fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val result = mutableListOf<String>()
        val map = hashMapOf<Char, Int>()

        words2.forEach { word ->
            val temp = word.groupingBy { it }.eachCount()
            temp.forEach { (k, v) ->
                map[k] = max(map.getOrDefault(k, 0), v)
            }
        }

        words1.forEach { word ->
            val valid = word.groupingBy { it }.eachCount()

            var put = false
            for ((k, v) in map) {
                if (valid.containsKey(k) && valid.getOrDefault(k, 0) >= v) {
                    put = true
                } else {
                    put = false
                    break
                }
            }

            if (put) {
                result.add(word)
            }
        }

        return result
}
