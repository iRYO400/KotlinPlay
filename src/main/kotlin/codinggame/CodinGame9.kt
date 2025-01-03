package codinggame

fun main() {

    val list = listOf("00", "0.")//listOf("00", "0.")
    System.err.println("_______")
    for (i in list.indices) {

        for (j in 0 until list[i].length) {
            val string = StringBuilder()

            if (list[i][j] == '.')
                continue

            string.apply {
                append("$j $i ")

                var tempJ = j + 1
                while (tempJ <= list[i].length) {
                    if (tempJ == list[i].length) {
                        append("-1 -1 ")
                        break
                    }
                    if (list[i][tempJ] == '.') {
                        tempJ++
                    } else {
                        append("$tempJ $i ")
                        break
                    }
                }

                var tempI = i + 1
                while (tempI <= list.size) {
                    if (tempI == list.size) {
                        append("-1 -1 ")
                        break
                    }

                    if (list[tempI][j] == '.') {
                        tempI++
                    } else {
                        append("$j $tempI ")
                        break
                    }
                }
            }
            System.err.println(string)
            println(string)
        }
    }
}