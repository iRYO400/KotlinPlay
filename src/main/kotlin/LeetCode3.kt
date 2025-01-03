fun main() {
    twoSum2(intArrayOf(2,7,11,15,7), 9).forEach {
        println("twoSum $it")
    }

    twoSum2(intArrayOf(2,4,11,15,7), 9).forEach {
        println("twoSum2 $it")
    }
    println(threeSum(intArrayOf(-1,0,1,2,-1,-4)))
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val result = IntArray(2)
    val map = hashMapOf<Int,Int>()

    for (num in nums) {
        map[num] = (map[num] ?: 0) + 1
    }

    hashSetOf<Int>()
    for (i in nums.indices) {
        val x = target - nums[i]
        val found = map[x]
        if (found != null && found > 0) {
            map[x] = (map[x] ?: 0) -1
            result[0] = i
            result[1] = nums.indexOf(x)
            break
        }
    }

    return result
}

fun twoSum2(nums: IntArray, target: Int): IntArray {
    val result = intArrayOf(-1,-1)
    val map = hashMapOf<Int,Int>()

    for (i in nums.indices) {
        if (map.containsKey(target - nums[i]))
            return intArrayOf(map[target - nums[i]]!!, i)
        map[nums[i]] = i
    }

    return result
}


fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    nums.sort()

    loop@ for (i in nums.indices) {
        if (i > 0 && nums[i] == nums[i-1]) continue

        val x = nums[i]
        var l = i + 1
        var r = nums.size - 1

        while (l < r) {

            if (- nums[l] - nums[r] > x) {
                r--
            } else if (-nums[l] -nums[r] < x) {
                l++
            } else if (-nums[l] -nums[r] == x) {
                result.add(listOf(x, nums[l], nums[r]))
                continue@loop
            }
        }
    }

    return result.toList()
}