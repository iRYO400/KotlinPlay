fun main() {

    println(isAnagram("anagram", "nagaram2"))
}


private fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    s.toList().sorted()
    val sortedS = s.toList().sorted()
    val sortedT = t.toList().sorted()

    var k = 0
    while (k < sortedS.size) {
        if (sortedS[k] == sortedT[k]) {
            k++
            continue
        } else {
            return false
        }
    }
    return true
}

private fun groupAnagram(strs: Array<String>): List<List<String>> {
    val result = MutableList<MutableList<String>>(strs.size) {
        mutableListOf()
    }

    val map = hashMapOf<String, MutableList<String>>()
    for (i in strs.indices) {
        val word = strs[i]
        val mutated = word.toList().sorted().toString()

        if (map.containsKey(mutated)) {
            map[mutated]?.add(word)
        } else {
            map[mutated] = mutableListOf(word)
        }
    }

    return map.values.toList()
}