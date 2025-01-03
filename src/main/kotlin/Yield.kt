import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import java.util.concurrent.atomic.AtomicInteger

class Yield {
    val current = AtomicInteger(0)
    val threshold = 10

    fun vowels() = sequence {
        yield("a")
        yield("e")
        yield("i")
        yield("o")
        yield("u")
    }

    fun fibonacci() = sequence {
        var terms = Pair(0, 1)
        while (true) {
            yield(terms.first)
            terms = Pair(terms.second, terms.first + terms.second)
        }
    }

    fun numberPrinter() = runBlocking {
        launch {
            while (current.get() < threshold) {
                if (current.get() % 2 == 0) {
                    println("$current is even")
                    current.incrementAndGet()
                }
                println("Current in first is ${current.get()}")
                yield()
            }
        }

        launch {
            while (current.get() < threshold) {
                if (current.get() % 2 != 0) {
                    println("$current is odd")
                    current.incrementAndGet()
                }
                println("Current in second is ${current.get()}")
                yield()
            }
        }
    }
}

fun main() {
    val client = Yield();

    // Cooperative Multitasking
    client.numberPrinter()

//    // Finite Sequence
//    val vowelIterator = client.vowels().iterator()
//    while (vowelIterator.hasNext()) {
//        println(vowelIterator.next())
//    }
//
//    // Infinite Sequence
//    val fibonacciIterator = client.fibonacci().iterator();
//    var count = 5
//    while (count > 0) {
//        println(fibonacciIterator.next())
//        count--;
//    }
}