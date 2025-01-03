//https://leetcode.com/problems/add-binary/description/

fun main() {
    val b1 = 0b11
    val b2 = 0b1

    println((b1 + b2).toUInt().toString(2))

    println(0 xor 1)
    println("...")
    println(addBinary("11", "1"))    //100
    println(addBinary("1010", "1011"))    //10101
    println(addBinary("1111", "1111"))    //11110
    println(addBinary("1110", "1011"))    //11001
    println(addBinary("111", "101"))      //1100
//    println(
//        addBinary(
//            "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
//            "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"
//        )
//    )
    println("...")

}


fun addBinary(a: String, b: String): String {
    var topIndex = a.length - 1
    var botIndex = b.length - 1

    var carry = 0

    val result = buildString {
        while (topIndex >= 0 || botIndex >= 0) {
            val x =
                if (topIndex < 0) 0
                else Character.getNumericValue(a[topIndex])

            val y =
                if (botIndex < 0) 0
                else Character.getNumericValue(b[botIndex])

            topIndex--
            botIndex--

            val value = if (carry != 1) {
                carry = x `and` y
                x `xor` y
            } else {
                val temp = x xor y `xor` carry
                carry = (x or y) and carry
                temp
            }

            insert(0, value)
        }
        if (carry == 1) {
            insert(0, 1)
        }
    }

    return result
}
