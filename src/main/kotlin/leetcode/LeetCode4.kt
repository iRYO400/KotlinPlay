package leetcode// https://leetcode.com/problems/3sum-closest/description/

fun main() {
    println(threeSumClosest(intArrayOf(2,3,8,9,10), 16))
}

fun threeSumClosest(nums: IntArray, target: Int): Int {
    var result = 0

    nums.sort()

    var nearestSum = result

    var isNearestInited = false

    for (i in nums.indices) {
        // x + y + z = target
        // x + y + z ~= target
        // z ~= target - x - y
        val x = nums[i]
        var left = i + 1
        var right = nums.size - 1


        while (left < right) {
            val y = nums[left]
            val z = nums[right]
            val threesum = x + y + z

            if (!isNearestInited) {
                isNearestInited = true
                nearestSum = threesum
            }

            if (threesum > target) {
                right--
                val n1 = Math.abs(target - nearestSum)
                val n2 = Math.abs(target - threesum)

                if (n1 < n2) {
                    nearestSum = nearestSum
                } else {
                    nearestSum = threesum //2
                }
            } else if (threesum < target) {
                left++
                val n1 = Math.abs(target - nearestSum)
                val n2 = Math.abs(target - threesum)

                if (n1 < n2) {
                    nearestSum = nearestSum
                } else {
                    nearestSum = threesum //-4, -3
                }
            } else {
                nearestSum = threesum
                left++
                while (nums[left] == nums[left - 1] && left < right) {
                    left++
                }
            }
        }
    }

    result = nearestSum

    return result
}
