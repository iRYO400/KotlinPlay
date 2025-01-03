//https://leetcode.com/problems/diagonal-traverse
fun main() {
    findDiagonalOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))).forEach {
        print("$it, ")
    }
}

fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
    val N = mat.size
    val M = mat[0].size
    val result = IntArray(M * N)

    var row = 0
    var column = 0
    var idx = 0
    var isUp = true

    while (row < N && column < M) {
        result[idx] = mat[row][column]
        idx++

        val newRow = row + if (isUp) -1 else 1
        val newColumn = column + if (isUp) 1 else -1

        val isWithinBounds = newRow in 0 until N
                && newColumn in 0 until M

        if (isWithinBounds) {
            row = newRow
            column = newColumn
        } else {
            if (isUp) {
                row += if (column == M - 1) 1 else 0
                column += if (column < M - 1) 1 else 0
            } else {
                column += if (row == N - 1) 1 else 0
                row += if (row < N - 1) 1 else 0
            }

            isUp = !isUp
        }
    }
    // [0][0] 0 = 0
    // [0][1] 1 = 1
    // [1][0] 2 = 1
    // [2][0] 3 = 2
    // [1][1] 4 = 2
    // [0][2] 5 = 2
    // [1][2] 6 = 3
    // [2][1] 7 = 3
    // [2][2] 8 = 3
    return result
}