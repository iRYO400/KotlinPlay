package leetcode

// https://leetcode.com/problems/search-insert-position
fun main() {
//    println(searchInsert(intArrayOf(1, 3), 2))

    println(searchInsert2024(intArrayOf(1, 3, 5, 6), 5))
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size - 1

    while (l <= r) {
        val mid = (l + r) / 2

        if (target == nums[mid])
            return mid

        if (nums[mid] < target) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }

    return l
}

private fun searchInsert2024(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.size - 1

    while (l <= r) {
        val mid = l + ((r - l) / 2)
        if (target == nums[mid]) {
            return mid
        }
        if (target > nums[mid]) {
            l = mid
        } else if (target < nums[mid]) {
            r = mid
        } else {
            return mid
        }
    }
    return l
}