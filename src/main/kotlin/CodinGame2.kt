fun main() {

    val string = ""
    val alphabet = ""
    for (i in string.indices) {
        val char = string[i]

        val L = 4

        val indexMultiplier = getIndexBy(char)

        val start = L * indexMultiplier
        val end = start + L - 1

        val sliced = alphabet.slice(IntRange(start, end))
    }
}

private fun getIndexBy(char: Char): Int = when (char) {
    'A', 'a' -> 0
    'B', 'b' -> 1
    'C', 'c' -> 2
    'D', 'd' -> 3
    'E', 'e' -> 4
    'F', 'f' -> 5
    'G', 'g' -> 6
    'H', 'h' -> 7
    'I', 'i' -> 8
    'J', 'j' -> 9
    'K', 'k' -> 10
    'L', 'l' -> 11
    'M', 'm' -> 12
    'N', 'n' -> 13
    'O', 'o' -> 14
    'P', 'p' -> 15
    'Q', 'q' -> 16
    'R', 'r' -> 17
    'S', 's' -> 18
    'T', 't' -> 19
    'U', 'u' -> 20
    'V', 'v' -> 21
    'W', 'w' -> 22
    'X', 'x' -> 23
    'Y', 'y' -> 24
    'Z', 'z' -> 25
    else -> 26
}