import java.math.BigInteger

fun main() {
    val value = -3

    println("#toBinaryUnsigned ...")
    println(toBinaryUnsigned(value))
    println("#toBinaryUnsigned32 ...")
    println(toBinaryUnsigned32(value))

    println("###Task###")
    println(reverseBits(value))
    println("###Task using binary shift")
    println(reverseBits2(value))
    println("###Task using UInt")
    println(reverseBits3(value))

    var d = 3.inv() // point
    d++
    println(d)
}

// you need treat n as an unsigned value
fun reverseBits(n: Int): Int {
    val binaryString = StringBuilder()
    val binary = Integer.toBinaryString(n)

    val until32 = 32 - binary.length
    for (i in 0 until until32) {
        binaryString.append("0")
    }

    binaryString.append(binary)
    binaryString.reverse()


    val result = binaryString.toString().toBigInteger(2)

    return result.toInt()
}


// unsigned only
fun toBinaryUnsigned(n: Int): String {
    return if (n != 0) {
        toBinaryUnsigned(n / 2) + n % 2
    } else {
        ""
    }
}


// unsigned only
fun toBinaryUnsigned32(n: Int): String {
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


fun reverseBits2(n: Int): Int {
    var temp = n
    var result = 0

    for (i in 0 until 32) {
        result = result shl 1
//        result += temp and 1 // or below
        if (temp and 1 == 1) result++
        temp = temp shr  1
    }

    return result
}

fun reverseBits3(n: Int): Int {
    val binary = toBinaryUnsigned32(n)

    return binary.toBigInteger(2).toInt()
}
