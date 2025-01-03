private const val CONSTANT_OUT = 99

class ScopeOfVisibility {

    companion object {
        private const val CONSTANT_IN = 101
    }

    fun todo() {
        println(CONSTANT_OUT)
        println(CONSTANT_IN)
    }
}


fun main() {
    val scopeOfVisibility = ScopeOfVisibility()
    scopeOfVisibility.todo()

    val a = A(5)
    val b = B(5)
    println("Elder to young ${a.equals(b)}")
    println("Revers ${b.equals(a)}")
}

open class A(private val value: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as A

        return value == other.value
    }

    override fun hashCode(): Int {
        return value
    }
}

class B
//private
constructor(value: Int) : A(value) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false
        return true
    }

}