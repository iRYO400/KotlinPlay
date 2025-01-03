package codinggame

fun main() {
    solve("12")
}


private fun solve(s: String) {

    var x = 1
    s.forEach {
        println(it)
        x *= (it.digitToInt() + 1)
    }

    println(x)
}