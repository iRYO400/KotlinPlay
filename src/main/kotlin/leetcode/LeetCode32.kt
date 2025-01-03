package leetcode

fun main() {

    println(isHappy(111111))
}

private fun isHappy(n: Int): Boolean {
    var result = false

    var temp = n

    while (true) {
        temp = getSquaredSum(temp)

        if (temp == 1) {
            result = true
            break
        } else if (temp <= 4) {
            result = false
            break
        }
    }

    return result
}

private fun getSquaredSum(n: Int): Int {
    var result = 0
    var temp = n

    while (temp > 0) {
        val d = temp % 10
        temp /= 10
        result += d * d
    }

    return result
}