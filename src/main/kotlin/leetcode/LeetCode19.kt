package leetcode

//https://leetcode.com/problems/daily-temperatures
fun main() {

    dailyTemperaturesBruteForce(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).forEach {
        print("$it, ")
    }
    println()
    dailyTemperaturesRTL(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).forEach {
        print("$it, ")
    }
    println()
    dailyTemperaturesStack(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).forEach {
        print("$it, ")
    }
    println()
    dailyTemperaturesRTL_Stack(intArrayOf(50,30,40,50,60)).forEach {
        print("$it, ")
    }
}

/**
 * Not efficient in leetcode case when N = 10_000 [99,99,99,99,99...N-1, 100]
 */
fun dailyTemperaturesStack(temperatures: IntArray): IntArray {
    val nums = temperatures // short name
    val result = IntArray(nums.size) // assume that default values are zeros
    val stack = ArrayDeque<Int>() // temp to index

    for (i in nums.indices) {
        while (stack.isNotEmpty() && nums[stack.last()] < nums[i]) {
            val storedIdx = stack.removeLast()
            result[storedIdx] = i - storedIdx
        }
        stack.addLast(i)
    }

    return result
}

fun dailyTemperaturesRTL_Stack(temperatures: IntArray): IntArray {
    val nums = temperatures // short name
    val result = IntArray(nums.size) // assume that default values are zeros
    val diffs = IntArray(nums.size - 1) // delta between two numbers

    var idx = nums.size - 2 // two because the last is always 2
    while (idx >= 0) {

        var diff = nums[idx + 1] - nums[idx]
        diffs[idx] = diff

        if (diff > 0) {
            result[idx] = 1
        } else {
            var j = idx + 1
            while (diff <= 0 && j < nums.size - 1) {
                diff += diffs[j]
                j++
            }

            // check if `while` found the answer,
            // then diff will be greater than 0
            if (diff <= 0) {
                result[idx] = 0
            } else {
                result[idx] = j - idx
            }
        }
        idx--
    }

    return result
}

fun dailyTemperaturesRTL(temperatures: IntArray): IntArray {
    val nums = temperatures // short name
    val result = IntArray(nums.size) // assume that default values are zeros
    val diffs = IntArray(nums.size - 1) // delta between two numbers

    var idx = nums.size - 2 // two because the last is always 2
    while (idx >= 0) {

        var diff = nums[idx + 1] - nums[idx]
        diffs[idx] = diff

        if (diff > 0) {
            result[idx] = 1
        } else {
            var j = idx + 1
            while (diff <= 0 && j < nums.size - 1) {
                diff += diffs[j]
                j++
            }

            // check if `while` found the answer,
            // then diff will be greater than 0
            if (diff <= 0) {
                result[idx] = 0
            } else {
                result[idx] = j - idx
            }
        }
        idx--
    }

    return result
}

fun dailyTemperaturesBruteForce(temperatures: IntArray): IntArray {
    val nums = temperatures // short name
    val result = IntArray(temperatures.size) // assume that default values are zeros

    for (i in nums.indices) {
        var counter = 1
        inner@ for (j in i + 1 until nums.size) {
            if (nums[i] < nums[j]) {
                result[i] = counter
                break@inner
            }
            counter++
        }
    }

    return result
}