fun main() {

    println(gcdOfStrings("ABABABAB", "ABAB"))
    println(gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"))
    println(gcdOfStrings("LEET", "CODE").ifBlank { "`EMP†Y`" })
}

private fun gcdOfStrings(str1: String, str2: String): String {
    var result = ""
    var divider = if (str1.length > str2.length) str2 else str1

    while (true) {
        val array1 = str1.split(divider).filter { it.isNotBlank() }
        val array2 = str2.split(divider).filter { it.isNotBlank() }

        if (array1.isEmpty() && array2.isEmpty()) {
            result = divider
            break
        }

        if (divider.length > 2) {
            divider = divider.dropLast(2)
        } else {
            break
        }
    }

    return result
}