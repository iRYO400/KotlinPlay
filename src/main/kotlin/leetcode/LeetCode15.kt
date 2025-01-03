package leetcode

fun main() {

    println(reverse(123))
}

// -2147483647
// 2147483647
// 7463847412
// 1999999999
// 9999999991
fun reverse(x: Int): Int {
    if (x > -10 && x < 10) return x

    var temp = x
    var reversedValue = 0
    while (temp != 0) {
        if (reversedValue > Int.MAX_VALUE / 10 ||
            reversedValue < Int.MIN_VALUE / 10)
            return 0
        reversedValue = (reversedValue * 10) + (temp % 10)
        temp /= 10
    }

    return reversedValue
}
