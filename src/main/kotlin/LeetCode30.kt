fun main() {

    println(checkInclusion("ab", "eidboaoo"))
    println(checkInclusion("adcv", "dcvda"))
//    println(checkInclusion2("ab", "eidboaoo"))
    println(checkInclusion2("adcv", "dcvda"))
}

private fun checkInclusion(s1: String, s2: String): Boolean {
    var result = false

    val map = hashMapOf<Char, Int>() // letter to quantity

    s1.forEach {
        if (map.contains(it)) {
            map[it] = map[it]!! + 1
        } else {
            map[it] = 1
        }
    }

    val stack = ArrayDeque<Char>()
    s2.forEach {
        if (map.contains(it)) {
            stack.addLast(it)

            if (map[it]!! <= 1) {
                map.remove(it)
            } else {
                map[it] = map[it]!! - 1
            }
            if (stack.size == s1.length) {
                result = true
            }
        } else {
            while (stack.isNotEmpty()) {
                val char = stack.removeLast()
                if (map.contains(char)) {
                    map[char] = map[char]!! + 1
                } else {
                    map[char] = 1
                }
            }
        }
    }

    return result
}

private fun checkInclusion2(s1: String, s2: String): Boolean {
    var result = false

    val map = hashMapOf<Char, Int>() // letter to quantity

    s1.forEach {
        if (map.contains(it)) {
            map[it] = map[it]!! + 1
        } else {
            map[it] = 1
        }
    }

    var l = 0
    var r = 0
    val stack = ArrayDeque<Char>()

    while (l <= r && r < s2.length) {
        if (map.contains(s2[r])) {

            if (map[s2[r]]!! <= 1) {
                map.remove(s2[r])
            } else {
                map[s2[r]] = map[s2[r]]!! - 1
            }
            stack.addLast(s2[r])
            r++

            if (r - l == s1.length) {
                result = true
            }
        } else {
            while (stack.isNotEmpty()) {
                val char = stack.removeLast()
                if (map.contains(char)) {
                    map[char] = map[char]!! + 1
                } else {
                    map[char] = 1
                }
            }

            l++
            r = l
        }
    }

    return result
}

