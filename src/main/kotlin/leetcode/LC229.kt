package leetcode

fun main() {
    println("majority2Element ${majorityElement(intArrayOf(3, 2, 3))}")
    println("majority2Element2 ${majorityElement2(intArrayOf(3, 2, 3))}")
}

private fun majorityElement(nums: IntArray): List<Int> {
    val result = mutableSetOf<Int>()
    val map = hashMapOf<Int, Int>()

    for (num in nums) {
        map[num] = (map[num] ?: 0) + 1

        if (map.getOrDefault(num, 0) > nums.size / 3) {
            result.add(num)
        }
    }

    return result.toList()
}

private fun majorityElement2(nums: IntArray): List<Int> {
    val result = mutableSetOf<Int>()
    var candidate1 = 0
    var counter1 = 0
    var candidate2 = 0
    var counter2 = 0

    for (num in nums) {
        when {
            candidate1 == num -> counter1++
            candidate2 == num -> counter2++
            counter1 == 0 -> {
                candidate1 = num
                counter1 = 1
            }

            counter2 == 0 -> {
                candidate2 = num
                counter2 = 1
            }

            else -> {
                counter1--
                counter2--
            }
        }
    }

    counter1 = 0
    counter2 = 0
    for (num in nums) {
        if (candidate1 == num) counter1++
        else if (candidate2 == num) counter2++
    }

    if (counter1 > nums.size / 3)
        result.add(candidate1)
    if (counter2 > nums.size / 3)
        result.add(candidate2)

    return result.toList()
}
