package codinggame

fun main() {

    val word = "%"

    val binary = StringBuilder()
    for (i in word.indices) {
        binary.append(word[i].charToBinary())
    }

    println(solution(binary.toString()))
}

private fun solution(binary: String): String {
    val result = StringBuilder()
    var l = 0
    var r = 0
    var counter = 0

    while (l <= r) {
        val charL = binary[l]
        val charR = binary[r]

        if (charL == charR) {
            r++
            counter++
        } else {
            encode(charL, result, counter)
            result.append(" ")
            l += counter
            counter = 0
        }

        if (r == binary.length) {
            encode(charL, result, counter)
            break
        }
    }

    return result.toString()
}

private fun encode(left: Char, result: StringBuilder, counter: Int) {
    when (left) {
        '0' -> {
            result.append("00 ")
            for (i in 0 until counter) {
                result.append("0")
            }
        }
        '1' -> {
            result.append("0 ")
            for (i in 0 until counter) {
                result.append("0")
            }
        }
    }
}

private fun Char.charToBinary(): String {
    val string = StringBuilder()
    var temp = code

    while (temp != 0) {
        val num = temp % 2
        string.append(num)
//        if (temp % 2 == 1)
//            string.append("1")
//        else
//            string.append("0")
        temp /= 2
    }

    while (string.length < 7) {
        string.append("0")
    }

    return string.reverse().toString()
}