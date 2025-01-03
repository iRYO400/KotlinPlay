fun main() {

//    println(findMedianSortedArrays2(intArrayOf(1,3), intArrayOf(2)))
    println(findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2)))
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var result = 0.0
    val total = nums1.size + nums2.size
    val half = total / 2
    val isEven = total % 2 == 0

    var a = nums1
    var b = nums2

    // Makes a always be shorter than b
    if (b.size < a.size) {
        a = nums2
        b = nums1
    }

    var left = 0
    var right = a.size -1

    while (true) {
        val i = (left + right) / 2 // A
        val j = half - i - 1  // B

        val aLeft = if (i >= 0) a[i] else Int.MIN_VALUE
        val aRight = if (i + 1 < a.size) a[i + 1] else Int.MAX_VALUE
        val bLeft = if (j >= 0) b[j] else Int.MIN_VALUE
        val bRight = if (j + 1 < b.size) b[j + 1] else Int.MAX_VALUE

        // partition is correct
        if (aLeft <= bRight && bLeft <= aRight) {
            if (isEven) {
                return (Math.min(aRight, bRight) + Math.max(aLeft, bLeft)) / 2.0
            } else {
                return Math.min(aRight, bRight).toDouble()
            }
        } else if (aLeft > bRight) {
            right = i - 1
        } else {
            left = i + 1
        }
    }

    return result
}

fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double =
    solve(nums1, nums2, intArrayOf(), (nums1.size + nums2.size) / 2, (nums1.size + nums2.size) % 2 == 0)


tailrec fun solve(
    nums1: IntArray,
    nums2: IntArray,
    result: IntArray = intArrayOf(),
    middle: Int,
    even: Boolean
): Double = when {
    result.size > middle -> {
        if (even) (result[middle - 1] + result[middle]).toDouble() / 2.0
        else result[middle].toDouble()
    }
    nums1.isEmpty() && !nums2.isEmpty() -> {
        solve(intArrayOf(), intArrayOf(), result.plus(nums2), middle, even)
    }
    !nums1.isEmpty() && nums2.isEmpty() -> {
        solve(intArrayOf(), intArrayOf(), result.plus(nums1), middle, even)
    }
    nums1[0] > nums2[0] -> {
        solve(nums1, nums2.drop(1).toIntArray(), result.plus(nums2[0]), middle, even)
    }
    else -> {
        solve(nums1.drop(1).toIntArray(), nums2, result.plus(nums1[0]), middle, even)
    }
}