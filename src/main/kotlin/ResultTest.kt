import kotlin.coroutines.cancellation.CancellationException

fun main() {
    outer()

    getResult()

    println()
    resultRecovery()

    println()
    checkSuccess()

    println()
    checkChain()
}

private fun checkSuccess() {
    runCatchingNonCancellation {
        println("Success Started ")
        "result"
    }.onSuccess {
        println("onSuccess $it")
    }.onFailure {
        println("onFailure")
    }
}

private fun outer() {
    runCatchingNonCancellation {
        println("outer: ${inner()}")
    }.onFailure {
        println("outer error $it")
    }
}

private fun inner(): Result<String> {
    return runCatchingNonCancellation {
        error("BOOM")
    }.onFailure { error ->
        println("inner error $error")
        throw error
    }
}

inline fun <R> runCatchingNonCancellation(block: () -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Result.failure(e)
    }
}


private fun getResult() {
    val result = runCatchingNonCancellation {
        error("Bomb!")
    }.onFailure {
        println("Caught $it")
    }.getOrNull()

    println("Result is $result")
}

private fun resultRecovery() {
    val result = runCatchingNonCancellation {
        error("BOOBA!")
    }.recover {
        if (it is RuntimeException) {

        } else {
            emptyMap<String, String>()
        }
    }

    println("Result is $result")
}

private fun checkChain() {
    runCatchingNonCancellation {
        println("Books are ready")
        error("Books got stolen")
    }.onFailure {
        println(it)
    }.recover {
        listOf("Movies")
    }.map {
        println("Replaced to Movies: $it")
    }
}