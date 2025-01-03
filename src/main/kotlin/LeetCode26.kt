fun main() {
    println(generate(5))
}


private fun generate(numRows: Int): List<List<Int>> {
    val result = ArrayList<List<Int>>(numRows)

    for (i in 0 until numRows) {
        if (i == 0) {
            result.add(listOf(1))
            continue
        }
        if (i == 1) {
            result.add(listOf(1, 1))
            continue
        }

        val innerList = ArrayList<Int>(i + 1)
        for (j in 0 until i + 1) {
            if (j == 0 || j == i) {
                innerList.add(1)
            } else {
                innerList.add(result[i - 1][j - 1] + result[i - 1][j])
            }
        }
        result.add(innerList)
    }

    return result
}