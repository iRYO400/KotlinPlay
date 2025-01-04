fun main() {

    dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).forEach {
        println("dailyTemperatures $it")
    }

    println("waysToSplitArray 1 ${waysToSplitArray(intArrayOf(10, 4, -8, 7))}")
    println("waysToSplitArray 2 ${waysToSplitArray(intArrayOf(0, 0))}")
    println(
        "waysToSplitArray 3 ${
            waysToSplitArray(
                intArrayOf(
                    0,
                    -1,
                    -2,
                    -3,
                    -4,
                    -5,
                    -6,
                    -7,
                    -8,
                    -9,
                    -10,
                    -11,
                    -12,
                    -13,
                    -14,
                    -15,
                    -16,
                    -17,
                    -18,
                    -19,
                    -20,
                    -21,
                    -22,
                    -23,
                    -24,
                    -25,
                    -26,
                    -27,
                    -28,
                    -29,
                    -30
                )
            )
        }"
    )


    println("twoSum ${twoSum(intArrayOf(2, 7, 11, 15), 9)}")
}

private fun dailyTemperatures(temperatures: IntArray): IntArray {
    val result = IntArray(temperatures.size) { 0 } // assume that default values are zeros

    var i = 0
    while (i < temperatures.size) {
        var counter = 1
        var j = i + 1
        inner@ while (j < temperatures.size) {
            if (temperatures[i] < temperatures[j]) {
                result[i] = counter
                break@inner
            }
            counter++
            j++
        }
        i = j
    }

    return result
}

private fun waysToSplitArray(nums: IntArray): Int {
    var result = 0
    val allSum = nums.fold(0L) { acc, i -> acc + i }
    var leftSum = 0L

    for (i in 0..<nums.lastIndex) {
        leftSum += nums[i]
        val rightSum = allSum - leftSum
        if (leftSum >= rightSum) {
            result++
        }
    }

    return result
}

/**
    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
private fun twoSum(numbers: IntArray, target: Int): IntArray {
    val result = IntArray(2)

    var l = 0
    var r = numbers.size - 1

    while (l < r) {
        val sum = numbers[l] + numbers[r]

        if (sum > target) {
            r--
        } else if (sum < target) {
            l++
        } else {
            result[0] = l + 1
            result[1] = r + 1
            break
        }
    }

    return result
}
