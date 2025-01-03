
fun main() {
    val n = 10
    val d = n * 0
    println("$n and $d")

    print("Positive Pow ")
    println(myPowBitwise(5.0, 10))
    print("Recursive Pow ")
    println(myPowRecursive(5.0, 10))
}

fun myPowRecursive(x: Double, n: Int): Double {
    val result = calcPow(x, n)
    return if (n > 0) result else 1 / result
}

private fun calcPow(x: Double, n: Int): Double {
    if (n == 0 || x == 1.0)
        return 1.0
    if (x == 0.0)
        return 0.0

    val halfPower = n / 2
    val result = calcPow(x, halfPower)

    return if (n % 2 == 0) {
        result * result
    } else {
        x * result * result
    }
}

fun myPowBitwise(x: Double, n: Int): Double {
    if (n == 0)
        return 1.0

    var result = 1.0
    var number = x
    var multiplier = Math.abs(n)

    val isNegative = n < 0

    while (multiplier != -1 && multiplier != 0) {
        val isLSB = multiplier and 1

        if (isLSB > 0) {
            result *= number
        }

        number *= number

        multiplier = multiplier shr 1
    }

    if (isNegative) {
        result = 1 / result
    }

    return result
}