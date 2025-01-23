package leetcode

fun main() {
    println(search(intArrayOf(2, 5), 2))
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
}

/**
 * Левый-правый указатели. Динамически двигаем "зону" поиска, сжимая ее изменяя left/right.
 */
private fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (nums[mid] == target) {
            return mid
        } else if (nums[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return -1
}