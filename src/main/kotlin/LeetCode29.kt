fun main() {

    shuffle(intArrayOf(2, 5, 1, 3, 4, 7), 3).forEach {
        print(it)
    }
}

private fun shuffle(nums: IntArray, n: Int): IntArray {
    val array = IntArray(nums.size)

    var i = 0
    var l = 0
    var r = n
    while (i < nums.size) {
        array[i] = nums[l]
        array[i + 1] = nums[r]
        l++
        r++
        i += 2
    }

    return array
}