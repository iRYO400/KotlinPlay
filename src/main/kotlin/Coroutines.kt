import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.sync.Semaphore
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference

private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Unconfined)


fun main() {
//    `Semaphores in Java and Kotlin`()

    val boolean = AtomicBoolean()
    boolean.get()
    val i = AtomicInteger()
    i.incrementAndGet()
    AtomicReference<Yield>()
    val channel = Channel<String>()
    runBlocking {
        println("Channel before")

        launch {
            delay(1500)
            channel.send("Hope")
        }

        val result = channel.receive()

        println("Channel after $result")
    }

//    `cancelling coroutine is similar to throwing exception`()
//    `throwing an exception in coroutines`()
//    `throwing an exception in coroutines 2`()

//    `cold flow example`()
//    `additional cold flows`()
//    `SharedFlow with tryEmit`()
//    `SharedFlow with replay`()

//    `checking coroutineScope with launch`()
//    `coroutineScope and the magic of await call`()
//    `checking the coroutine scope created by this_builders`()
//    `coroutineScope magic as parallel decomposition`()
//    `join of Job is important cause it is suspend function and keeps the ordering of print in this case`()

}

private fun `cancelling coroutine is similar to throwing exception`() {
    runBlocking {
        val job = launch {
            val child = launch {
                try {
                    delay(Long.MAX_VALUE)
                } finally {
                    println("Child is cancelled")
                }
            }
            yield()
            println("Cancelling child")
            child.cancel()
            child.join()
            yield()
            println("Parent is not cancelled")
        }
        job.join()
    }
}

fun `throwing an exception in coroutines 2`() {
    runBlocking {
        try {
            launch {
                delay(1000)
                println("Throwing some exception")
                throw IllegalStateException("Some error")
            }
        } catch (e: Throwable) {
            println("Catching exception")
        }

        launch {
            delay(2000)
            println("Second launch")
        }
    }
}

@OptIn(DelicateCoroutinesApi::class)
private fun `throwing an exception in coroutines`() {
    runBlocking {
        val job = GlobalScope.launch { // root coroutine with launch
            println("Throwing exception from launch")
            throw IndexOutOfBoundsException() // Will be printed to the console by Thread.defaultUncaughtExceptionHandler
        }
        job.join()
        println("Joined failed job")
        val deferred = GlobalScope.async { // root coroutine with async
            println("Throwing exception from async")
            throw ArithmeticException() // Nothing is printed, relying on user to call await
        }
        try {
            deferred.await()
            println("Unreached")
        } catch (e: ArithmeticException) {
            println("Caught ArithmeticException")
        }
    }
}

private fun `Semaphores in Java and Kotlin`() {
    val semaphoreKt = Semaphore(1)
    val semaphore = java.util.concurrent.Semaphore(1)
}

private fun `cold flow example`() {
    runBlocking {
        flow {
            emit(100)
        }
            .collect {// completes automatically
                println("Flow collecting $it")
            }
    }
}

private fun `SharedFlow with tryEmit`() {
    val sharedFlow = MutableSharedFlow<Int>()

    sharedFlow.tryEmit(5)

    runBlocking {
        sharedFlow.collect {
            println("Collector is received: it")
        }
    }
}

private fun `additional cold flows`() {
    callbackFlow<Int> {

    }
    channelFlow<Int> {

    }
}

private fun `SharedFlow with replay`() {
    val sharedFlow = MutableSharedFlow<Int>(replay = 2)

    runBlocking {

        sharedFlow.emit(1)
        sharedFlow.emit(2)
        sharedFlow.emit(3)

        val a = async {
//            println("launch is executed")
            sharedFlow.collect {
                println("Collector 1 received: $it")
            }
        }

//        println("preparing second collector")
//        sharedFlow.emit(4)
//        sharedFlow.emit(5)

        a.await()
        launch {
            sharedFlow.collect {
                println("Collector 2 received: $it")
            }
        }
    }
}

private fun `join of Job is important cause it is suspend function and keeps the ordering of print in this case`() {
    runBlocking {
        val request = launch {
            repeat(3) { i -> // launch a few children jobs
                launch {
                    delay((i + 1) * 500L) // variable delay 200ms, 400ms, 600ms
                    println("Coroutine $i is done")
                }
            }
            println("request: I'm done and I don't explicitly join my children that are still active")
        }
        request.join() // wait for completion of the request, including all its children
        println("Now processing of the request is complete")
    }
}

private fun `checking the coroutine scope created by this_builders`() {
    runBlocking {
        println("started ${this.toString()}")

        launch {
            println("launch ${this.toString()}")
        }

        async {
            println("async ${this.toString()}")
        }

        coroutineScope {
            println("just scope ${this.toString()}")
        }
    }
}

private fun `coroutineScope magic as parallel decomposition`() {
    runBlocking {
        val x = coroutineScope {
            val a = async {//parallel
                delay(1500)
                println("async a")
                3
            }
            val b = async {//parallel
                println("async b")
                4
            }
            launch {//parallel
                delay(1000)
            }
            println("Working b: ${b.await()}")
            println("Working a: ${a.await()}")
            5 + a.await() + b.await()
        }
        println("Parallel $x")
    }
}

private fun `checking coroutineScope with launch`() {
    coroutineScope.launch(start = CoroutineStart.DEFAULT) {
        println("Hello") // 1st print
        coroutineScope {
            launch {
                delay(1_000)
                println("World") // 3rd print
            }
            println("Big") // 2nd print
        }
        println("Suck")
    }
    Thread.sleep(1_500) // wait till coroutine finished
}

private fun `coroutineScope and the magic of await call`() {
    coroutineScope.launch {
        val deferred = coroutineScope.async(start = CoroutineStart.DEFAULT) {
            println("loading")
            delay(1000)
            println("loaded")
        }

        println("waiting")
        deferred.await()
    }

//    Thread.sleep(1_500) // wait till coroutine finished
}
