fun main() {
    println(findJudge(2, arrayOf(intArrayOf(1, 2))))
}

fun findJudge(n: Int, trust: Array<IntArray>): Int {
    var result = -1

    loop@for (i in 0..trust.size) {
        if (trust[i][1] != n) {
            return -1
        }
    }

    return result
}