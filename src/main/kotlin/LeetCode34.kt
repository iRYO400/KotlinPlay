import kotlin.math.abs

fun main() {
    println(containsNearbyDuplicate(intArrayOf(0, 1, 2, 3, 4, 0, 0, 7, 8, 9, 10, 11, 12, 0), 1))
}


fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val map = hashMapOf<Int, Int>()
    for (i in nums.indices) {
        if (map.contains(nums[i])) {
            val pos = map[nums[i]]!!
            if (abs(i - pos) <= k)
                return true
        }
        map[nums[i]] = i
    }

    return false
}

private fun checkLoop() {
    val hashMap = hashMapOf<Int, Int>()

}