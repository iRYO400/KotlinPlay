package leetcode

fun main() {
    val result = removeDuplicates(intArrayOf(0,0,1,1,1,2,2,3,3,4))
    println(result)

}

fun removeDuplicates(nums: IntArray): Int {
        var k = 0
    val map = hashMapOf<Int, Int>()
    map[0] = 0
    map[1] = 3
    for (num in nums) {
        map[num]?.let {
            map[num] = it + 1
        }
    }

    for (entry in map) {
        if (entry.value <= 0)
            continue

        entry.key
        entry.value
        entry.setValue(entry.value - 1)
    }

    println(map)

        loop@ for (i in nums.indices) {
//            if (i == 0) {
//                current = nums[0]
//                k++
//                continue@loop
//            }

            if (nums[i] != nums[k]) {
                nums[k] = nums[i]
                k++
            }
        }
        return k
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}