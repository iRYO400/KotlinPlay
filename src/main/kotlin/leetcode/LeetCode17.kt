package leetcode//https://leetcode.com/problems/next-greater-element-i/
import java.util.ArrayDeque

fun main() {
    nextGreaterElement(intArrayOf(1, 3, 5, 2, 4), intArrayOf(6, 5, 4, 3, 2, 1, 7)).forEach {
        println(it)
    }
    println(".........")

    nextGreaterElement2(intArrayOf(1, 3, 5, 2, 4), intArrayOf(6, 5, 4, 3, 2, 1, 7)).forEach {
        println(it)
    }
    nextGreaterElement2(intArrayOf(4,1,2), intArrayOf(1,3,4,2)).forEach {
        println(it)
    }
}

fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val result = IntArray(nums1.size)


    loop1@ for (i in nums1.indices) {
        var j = 0
        loop2@ while (j < nums2.size) {
            if (nums1[i] == nums2[j]) {
                loop3@ for (k in j + 1 until nums2.size) {
                    if (nums2[j] < nums2[k]) {
                        result[i] = nums2[k]
                        break@loop2
                    }
                }
            }
            j++
        }
        if (result[i] == 0) {
            result[i] = -1
        }
    }

    return result
}

fun nextGreaterElement2(nums1: IntArray, nums2: IntArray): IntArray {
    val map = hashMapOf<Int, Int>() // key is number, value is another number which is greater
    val stack = ArrayDeque<Int>()

    nums2.forEach {
        while (stack.isNotEmpty() && stack.peek() < it) {
            map[stack.pop()] = it
        }
        stack.push(it)
    }

    for (i in nums1.indices) {
        nums1[i] = map.getOrDefault(nums1[i], -1)
    }
    return nums1
}