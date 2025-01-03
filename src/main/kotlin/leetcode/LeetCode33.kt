package leetcode//https://leetcode.com/problems/number-of-1-bits/

fun main() {

    println(hammingWeight(-3))
    println(hammingWeight2(-3))
}

fun hammingWeight(n: Int): Int {
    var weight = 0

    val binary = toBinaryUnsignedString32(n)
    binary.forEach {
        if (Character.getNumericValue(it) == 1)
            weight++
    }

    return weight
}

fun hammingWeight2(n: Int): Int {
    var weight = 0

    var temp = n.toUInt()
    while (temp != 0u) {
        if (temp % 2u == 1u)
            weight++

        temp /= 2u
    }

    return weight
}

private fun toBinaryUnsignedString32(n: Int): String {
    val string = StringBuilder()
    var temp = n.toUInt()
    while (temp != 0u) {
        val num = temp % 2u
        string.append(num)
        temp /= 2u
    }

    while (string.length < 32) {
        string.append("0")
    }

    return string.toString()
}
