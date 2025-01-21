package leetcode

fun main() {
//    println(
//        "firstCompleteIndex is ${
//            firstCompleteIndex(
//                intArrayOf(1, 5, 4, 2, 3, 6),
//                arrayOf(intArrayOf(1, 4, 5), intArrayOf(2, 3, 6)),
//            )
//        }"
//    )
//    println(
//        "firstCompleteIndex is ${
//            firstCompleteIndex(
//                intArrayOf(2, 8, 7, 4, 1, 3, 5, 6, 9),
//                arrayOf(intArrayOf(3, 2, 5), intArrayOf(1, 4, 6), intArrayOf(8, 7, 9)),
//            )
//        }"
//    )
    println(
        "firstCompleteIndex is ${
            firstCompleteIndex(
                intArrayOf(1, 4, 5, 2, 6, 3),
                arrayOf(intArrayOf(4, 3, 5), intArrayOf(1, 2, 6)),
            )
        }"
    )
    println(
        "firstCompleteIndex2 is ${
            firstCompleteIndex2(
                intArrayOf(1, 4, 5, 2, 6, 3),
                arrayOf(intArrayOf(4, 3, 5), intArrayOf(1, 2, 6)),
            )
        }"
    )
}

/**
 * Time limit exceeded
 */
private fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
    val result = Int.MAX_VALUE

    val map = hashMapOf<Int, Pair<Int, Int>>()

    for (i in mat.indices) {
        for (j in mat[i].indices) {
            val value = mat[i][j]
            map[value] = i to j
        }
    }

    val painted = hashMapOf<Int, Pair<Int, Int>>()
    for (numIndex in arr.indices) {
        val num = arr[numIndex]
        val (i, j) = map[num] ?: throw IllegalArgumentException("FUCK YOU")
        painted[num] = i to j

        if (mat.size >= mat[0].size) {
            // search in row
            var paintedCount = 0
            for (rowI in mat.indices) {
                if (mat[rowI][j] == num) {
                    paintedCount++
                    continue
                }

                val value = mat[rowI][j]
                if (painted.contains(value)) {
                    paintedCount++
                } else {
                    paintedCount--
                }
            }

            if (paintedCount == mat.size) {
                return numIndex
            }

            paintedCount = 0
            for (columnJ in mat[i].indices) {
                if (mat[i][columnJ] == num) {
                    paintedCount++
                    continue
                }

                val value = mat[i][columnJ]
                if (painted.contains(value)) {
                    paintedCount++
                } else {
                    paintedCount--
                }
            }

            if (paintedCount == mat[i].size) {
                return numIndex
            }
        } else {
            var paintedCount = 0
            for (columnJ in mat[i].indices) {
                if (mat[i][columnJ] == num) {
                    paintedCount++
                    continue
                }

                val value = mat[i][columnJ]
                if (painted.contains(value)) {
                    paintedCount++
                } else {
                    paintedCount--
                }
            }

            if (paintedCount == mat[i].size) {
                return numIndex
            }

            paintedCount = 0
            for (rowI in mat.indices) {
                if (mat[rowI][j] == num) {
                    paintedCount++
                    continue
                }

                val value = mat[rowI][j]
                if (painted.contains(value)) {
                    paintedCount++
                } else {
                    paintedCount--
                }
            }

            if (paintedCount == mat.size) {
                return numIndex
            }
        }
    }

    return result
}

private fun firstCompleteIndex2(arr: IntArray, mat: Array<IntArray>): Int {
    val map = hashMapOf<Int, Pair<Int, Int>>()
    val m = mat.size
    val n = mat[0].size
    val paintedRow = IntArray(m) { 0 }
    val paintedColumn = IntArray(n) { 0 }

    for (i in mat.indices) {
        for (j in mat[i].indices) {
            val value = mat[i][j]
            map[value] = i to j
        }
    }

    for (numIndex in arr.indices) {
        val num = arr[numIndex]
        val (i, j) = map[num] ?: throw IllegalArgumentException("FUCK YOU")

        paintedRow[i]++
        paintedColumn[j]++

        if (paintedRow[i] == n || paintedColumn[j] == m)
            return numIndex
    }

    return -1
}
