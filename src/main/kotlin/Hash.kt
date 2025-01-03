fun main() {
    val hashMap = hashMapOf<String, String>()

    hashMap["idx"] = "Guy"
    printer(hashMap)
//    println(extractor(hashMap, "idx"))

    hashMap["zero"] = "Boy"
    printer(hashMap)

//    println(extractor(hashMap, "idx"))
    println(extractor(hashMap, "zero"))

    val student1 = Student("Oleg")
    val student2 = Student("Oleg")
    val teacher = Teacher("Oleg")

//    println("Equals ${student1.equals(teacher)}")
//    println("=== ${student1 == student2}")
}

class Student(private val name: String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}

data class Teacher(private val name: String) {

}

private fun printer(hashMap: HashMap<String, String>) {
    hashMap.forEach { t, u ->
        println("$t and $u")
    }
}

private fun extractor(hashMap: HashMap<String, String>, key: String) = hashMap.get(key)