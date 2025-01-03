import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.sample
import kotlinx.coroutines.launch
import java.util.LinkedList

fun main(args: Array<String>) {

    GlobalScope.launch {
        val flow = flow {
            repeat(10) {
                emit(it)
                delay(110)
            }
        }.sample(200)

        flow.collect {
            println(it)
        }
    }

    val newInstanceOfAbstractClass = object : AbstractClass() {
        override fun todoAbstract() {

        }
    }

    val result = compareTriplets(listOf(17, 28, 30), listOf(99, 16, 8))

    println(result)
}

/*
     * Complete the 'compareTriplets' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */
fun compareTriplets(a: List<Int>, b: List<Int>): List<Int> {
    val result: MutableList<Int> = ArrayList(2)
    result.add(0)
    result.add(0)

    for (i in a.indices) {
        val check = compare(a[i], b[i])
        if (check == -1) {
            result[0] = result[0] + 1
        } else if (check == 1) {
            result[1] = result[1] + 1
        }
    }

    val map = hashMapOf<Int, LinkedList<String>>()
    map.keys.sorted()
    return result
}

private fun compare(i: Int, j: Int): Int {
    if (i < j) {
        return -1
    } else if (i > j) {
        return 1
    }

    return 0
}

abstract class AbstractClass {

    abstract fun todoAbstract()
}