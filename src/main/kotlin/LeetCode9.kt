// https://leetcode.com/problems/add-two-numbers/

fun main() {
//    case1()
    case2()
}

private fun case1() {
    val l111 = ListNode(3)
    val l11 = ListNode(4)
    l11.next = l111
    val l1 = ListNode(2)
    l1.next = l11

    val l222 = ListNode(4)
    val l22 = ListNode(6)
    l22.next = l222
    val l2 = ListNode(5)
    l2.next = l22

    addTwoNumbers(l1, l2)?.let {
        println(it)
    }
}


private fun case2() {
    val l11111 = ListNode(9)
    val l1111 = ListNode(9)
    l1111.next = l11111
    val l111 = ListNode(9)
    l111.next = l1111
    val l11 = ListNode(9)
    l11.next = l111
    val l1 = ListNode(9)
    l1.next = l11

    val l222 = ListNode(9)
    val l22 = ListNode(9)
    l22.next = l222
    val l2 = ListNode(9)
    l2.next = l22

    addTwoNumbers(l1, l2)?.let {
        println(it)
    }
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    return sumUpNumbers(l1, l2, false)
}

fun sumUpNumbers(l1: ListNode?, l2: ListNode?, hasCarry: Boolean): ListNode? {
        if (l1 == null && l2 == null) {
            return if (hasCarry)
                ListNode(1)
            else null
        }
        val v1 = l1?.`val` ?: 0
        val v2 = l2?.`val` ?: 0
        val sum = v1 + v2 + if (hasCarry) 1 else 0
        val value = sum % 10
        val hasCarry = sum - value > 0

        val node = ListNode(value)
        node.next = sumUpNumbers(l1?.next, l2?.next, hasCarry)

        return node
}
