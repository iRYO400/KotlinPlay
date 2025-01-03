package leetcode

fun main() {

    println(5 % 4)
    println(convert("PAYPALISHIRING", 4))
}

fun convert(s: String, numRows: Int): String {
    val result = StringBuilder()

    val numColumns = numRows - 1 // if rows = 3, then columns = 2
    val zigZagCount = numRows + numColumns - 1

    for (row in 0 until numRows) {
        var j = row
        while (j <= s.length - 1) {
            val char = s[j]
            result.append(char)
            if (row in 1 until numRows - 1 &&
                j + zigZagCount - (2 * row) < s.length) {
                result.append(s[j + zigZagCount - (2 * row)])
            }
            j += zigZagCount
        }
    }

    return result.toString()
}
/**
 *    0 1 2 3 4 5 6 7 8
 * 0: P Y P L I H I I N
 * 1: A   А   S   R   G
 *
 *
 *    0 1 2 3 4 5 6
 * 0: P   A   H   N
 * 1: A P L S I I G
 * 2: Y   I   R
 *
 *
 * count = numRows + numColumn - 1
 *
 *
 *    1 2 3    4 5 6   7
 * 0: P        I       N
 * 1: A   L    S   I   G
 * 2: Y A      H R
 * 3: P        I
 *
 * 0: 0
 * 1: 1 |
 * 2: 2 + count - 2 = 2 + 6 - 2 = 6
 * 3:
 *
 *
 * 1: 0 + (4 - 1) * 2 = 6 | 6 + 6 = 12 | 12 + 6
 * 2: 1 + (4 - 2) * 2 = 5 | 5 + 2(?) = 7 | 7 + (4 - 2) * 2 = 11
 * 3: 2 + (4 - 3) * 2 = 4 |
 * 4: 3 + (4 - 4) * 2 = 3 | 3 + (4 - 4)
 *
 *    0 1 2 3 4 5 6 7 8 9
 * 0: P       H       D
 * 1: A     S I     Q F
 * 2: Y   I   R   P
 * 3: P L     I G
 * 4: A       N
 *
 *
 * P         R         E
 * A       I I       J L
 * Y     H   N     E   K
 * P   S     G   F     M
 * A I       P D       N
 * L         Q         D
 *
 *
 * numRows = N
 * numColumn = numRows - 1
 * count = numRows + numColumn - 1
 *
 * then Row1 == numRows, RowN == 1
 * then count = Row1 + numColumn - 1 = numRows + (numRows - 1) - 1
 * ### 3, count = 3 + (3 - 1) - 1 = 3 + 1 = 4
 * ### 4, count = 4 + (4 - 1) - 1 = 4 + 2 = 6
 * ### 5, count = 5 + (5 - 1) - 1 = 5 + 3 = 8
 */