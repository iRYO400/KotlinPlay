fun main() {

    val array = intArrayOf(1, 2, 3, 0, 0, 0)
    merge1(array, 3, intArrayOf(2, 5, 6), 3)
    array.forEach { print("$it, ") }

    println()
    val array2 = intArrayOf(1, 2, 3, 0, 0, 0)
    merge2(array2, 3, intArrayOf(2, 5, 6), 3)
    array2.forEach { print("$it, ") }

}

fun merge1(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var k = m
        var dynamicM = m
        for (i in nums2.indices) {
            var l = 0
            var r = dynamicM - 1

            while (l <= r) {
                var mid = l + ((r - l) / 2)

                if (nums1[mid] == nums2[i]) {
                    mid++
                    while (nums1[mid] == nums1[mid - 1] && mid <= r) {
                        mid++
                    }
                    l = mid
                } else if (nums1[mid] < nums2[i]) {
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            }

            nums1[k] = nums1[l]
            nums1[l] = nums2[i]
            k++
            dynamicM++
        }
    nums1.sort()
}

fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var mIndex = m - 1
    var nIndex = n - 1
    for (i in nums1.size - 1 downTo 0) {
        if (nIndex < 0) {
            break
        }
        if (mIndex < 0) {
            nums1[i] = nums2[nIndex]
            nIndex--
            continue
        }
        if (nums1[mIndex] <= nums2[nIndex]) {
            nums1[i] = nums2[nIndex]
            nIndex--
        } else {
            nums1[i] = nums1[mIndex]
            mIndex--
        }
    }
}

