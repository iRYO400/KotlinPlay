package leetcode

import kotlin.math.min

fun main() {
    println(5.countOneBits())

    println("minimizeXor ${minimizeXor(1, 12)}")
    println("minimizeXorGPT ${minimizeXorGPT(1, 12)}")
}

private fun minimizeXor(num1: Int, num2: Int): Int {
    var num2BitCount = num2.countOneBits()
    var result = 0

    for (i in 31 downTo 0) {
        if (num2BitCount == 0)
            break

        if (num1 and (1 shl i) > 0) {
            result = result or (1 shl i)
            num2BitCount--
        }
    }

    for (i in 0..31) {
        if (num2BitCount == 0)
            break

        if (result and (1 shl i) <= 0) {
            result = result or (1 shl i)
            num2BitCount--
        }
    }

    return result
}

private fun minimizeXorGPT(num1: Int, num2: Int): Int {
    val num2BitCount = Integer.bitCount(num2) // Число единичных битов в num2
    var x = 0
    var remainingBits = num2BitCount

    // Используем биты из num1
    for (i in 0 until 32) {
        if (remainingBits == 0) break // Если уже получили нужное количество битов
        if (num1 and (1 shl i) != 0) { // Проверяем, установлен ли бит i в num1
            x = x or (1 shl i) // Добавляем этот бит в x
            remainingBits--
        }
    }

    // Добавляем недостающие биты
    for (i in 0 until 32) {
        if (remainingBits == 0) break // Если уже получили нужное количество битов
        if (x and (1 shl i) == 0) { // Если бит i еще не установлен в x
            x = x or (1 shl i) // Добавляем этот бит в x
            remainingBits--
        }
    }

    return x
}