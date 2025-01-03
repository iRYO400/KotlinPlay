fun main() {

    parametersOf(collect().toTypedArray())
}

fun parametersOf(vararg parameters: Any?) {
    println(parameters)
    parameters.forEach {
        println(it)
    }
}

fun collect(): List<Any?> = listOf("boom", null)
