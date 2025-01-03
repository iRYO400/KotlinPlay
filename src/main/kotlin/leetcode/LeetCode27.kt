package leetcode

fun main() {
    println(maxProfit(intArrayOf(7,1,5,3,6,4)))

    val set = hashSetOf<Int>()
    set.last()
}

private fun maxProfit(prices: IntArray): Int {
    var result = 0

    var l = 0
    var r = 1

    while (l <= r && r <= prices.size - 1) {
        result = Math.max(result, prices[r] - prices[l])
        if (prices[l] > prices[r]) {
            l = r
        } else {
            r++
        }
    }

    return result
}