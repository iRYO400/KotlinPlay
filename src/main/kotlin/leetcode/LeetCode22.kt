package leetcode

import java.util.LinkedList

fun main() {

    val list = LinkedList<Int>()
    list.addLast(100)
    list.addLast(80)
    list.addLast(60)
//    list.addLast(70)

    val iterator = list.descendingIterator()

    while (iterator.hasNext()) {
        val next = iterator.next()
        if (next <= 70) {
            println(next)
        }
    }

    val arrayDeque = ArrayDeque<Int>()
}