private const val SKIPPED = -1

fun main(args: Array<String>) {

    val input = arrayOf(
        "187 / 249 / 0",
        "0 / 385 / 385",
        "60 / - / 0",
        "40 / 40 / 0",
        "270 / 315 / 0 ",
        "0/ 150 / 150",
        "550 / 522 / 0",
        "83 / 0 / 255",
        "0/ 40 / 40 ",
        "0/ 319 / -",
        "0/ 436 / 387 ",
        "257 / 202 / 0",
        "420 / 376 / 0",
        "200 / 200 / 0",
        "492 / 0 / 459",
        "370 / 0 / 370",
//        "0 / 97 / 97"
    )

    val relations = arrayOf(
        355, // Butya --> Vlad
        0, // Butya <-- Vlad
        0, // Vlad --> Adil
        0, // Vlad <-- Adil
        0, // Adil --> Butya
        185, // Adil <-- Butya
    )

    fun rebalance() {
        if (relations[0] > relations[1]) {
            val temp = relations[1]
            relations[1] = 0
            relations[0] = relations[0] - temp
        } else {
            val temp = relations[0]
            relations[0] = 0
            relations[1] = relations[1] - temp
        }

        if (relations[2] > relations[3]) {
            val temp = relations[3]
            relations[3] = 0
            relations[2] = relations[2] - temp
        } else {
            val temp = relations[2]
            relations[2] = 0
            relations[3] = relations[3] - temp
        }

        if (relations[4] > relations[5]) {
            val temp = relations[5]
            relations[5] = 0
            relations[4] = relations[4] - temp
        } else {
            val temp = relations[4]
            relations[4] = 0
            relations[5] = relations[5] - temp
        }
    }

    input.forEach { row ->
        val spendsStroke = row.split("/")
            .map { it.trim() }
            .map {
                if (it == "-") SKIPPED
                else it.toInt()
            }

        when {
            spendsStroke[0] == 0 -> {
                if (spendsStroke[1] != SKIPPED)
                    relations[1] = relations[1] + spendsStroke[1]
                if (spendsStroke[2] != SKIPPED)
                    relations[4] = relations[4] + spendsStroke[2]
                rebalance()
            }
            spendsStroke[1] == 0 -> {
                if (spendsStroke[0] != SKIPPED)
                    relations[0] = relations[0] + spendsStroke[0]
                if (spendsStroke[2] != SKIPPED)
                    relations[3] = relations[3] + spendsStroke[2]
                rebalance()
            }
            spendsStroke[2] == 0 -> {
                if (spendsStroke[0] != SKIPPED)
                    relations[5] = relations[5] + spendsStroke[0]
                if (spendsStroke[1] != SKIPPED)
                    relations[2] = relations[2] + spendsStroke[1]
                rebalance()
            }
        }
    }

    relations.forEach {
        println(it)
    }
}
