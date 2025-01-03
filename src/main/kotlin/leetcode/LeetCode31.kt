package leetcode

fun main() {

    println(totalFruit(intArrayOf(1, 2, 3, 2, 2)))
}

private fun totalFruit(fruits: IntArray): Int {
    val map = hashMapOf<Int, Int>()

    var max1 = 0
    var key1 = -1

    for (i in fruits.indices) {
        val key = fruits[i]

        if (map.contains(key)) {
            map[key] = map[key]!! + 1
        } else {
            map[key] = 1
        }

        max1 = Math.max(max1, map[key]!!)

        if (max1 == map[key]!!) {
            key1 = key
        }
    }

    map.clear()

    var max2 = 0

    for (i in fruits.indices) {
        val key = fruits[i]
        if (key1 == key)
            continue

        if (map.contains(key)) {
            map[key] = map[key]!! + 1
        } else {
            map[key] = 1
        }

        max2 = Math.max(max2, map[key]!!)
    }

    return max1 + max2
}

private fun totalFruit2(fruits: IntArray): Int {
    var maxPicked = 0

    val basket = hashMapOf<Int, Int>()
    var left = 0

    for (right in fruits.indices) {
//        basket[fruits[right]] = (basket[fruits] ?: 0) + 1

        if (basket.size > 2) {
            basket.put(fruits[left], basket[fruits[left]]!! - 1)
            if (basket[fruits[left]] == 0)
                basket.remove(fruits[left])
            left++
        }


        maxPicked = right - left
    }

    return maxPicked
}