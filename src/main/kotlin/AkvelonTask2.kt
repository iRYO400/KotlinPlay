/*Given an array arr[] consisting of N positive integers and an integer K,
 the task is to find the minimum number of array elements required
 to be replaced by the other array elements such
 that the array contains at most K distinct elements.

Input: arr[] = { 1, 1, 2, 2, 5 }, K = 2
Output: 1
Explanation:
Replacing arr[4] with arr[0] modifies arr[] to { 1, 1, 2, 2, 1 }
Distinct array elements of the array arr[] are { 1, 2 }
Therefore, the required output is 1.

Input: arr[] = { 5, 1, 3, 2, 4, 1, 1, 2, 3, 4 }, K = 3
Output: 3
Explanation:
Replacing arr[0] with arr[1] modifies arr[] to { 1, 1, 3, 2, 4, 1, 1, 2, 3, 4 }
Replacing arr[2] with arr[0] modifies arr[] to { 1, 1, 1, 2, 4, 1, 1, 2, 3, 4 }
Replacing arr[8] with arr[0] modifies arr[] to { 1, 1, 1, 2, 4, 1, 1, 2, 1, 4 }
Distinct array elements of the array arr[] are { 1, 2, 4 }
Therefore, the required output is 3.
*/

fun main() {
    println(solution(intArrayOf(1, 1, 2, 2, 5), 2))
    println(solution(intArrayOf(5, 1, 3, 2, 4, 1, 1, 2, 3, 4), 3))
}

fun solution(array: IntArray, k: Int): Int {
    var result = 0
    val map = hashMapOf<Int, Int>()

    array.forEach {
        if (map.contains(it)) {
            map[it] = map[it]!! + 1
        } else {
            map[it] = 1
        }
    }

    val tempMap = map.toList().sortedBy { (_, value) -> value }.toMap()

    var tempK = tempMap.size
    var counter = 0
    tempMap.forEach { t, u ->
        if (tempK != k) {
            counter += u
            tempK--
        }
    }

    return counter
}

