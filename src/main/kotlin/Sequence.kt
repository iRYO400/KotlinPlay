fun main() {


    val list = generateSequence(30) { it * 2 }

    println("sequence of ${list.take(5).toList()}")

    val seqs = sequence<Int> {
        yield(30)

        yieldAll(generateSequence(60) { it * 2 })
    }

    println("seq2 ${seqs.take(5).toList()}")
}