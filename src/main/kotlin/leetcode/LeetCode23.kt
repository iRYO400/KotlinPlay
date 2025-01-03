package leetcode

fun main() {
    println(trap(intArrayOf( 2, 1, 0, 1, 3, 2, 1, 2, 1)))

    println(trap2(intArrayOf(3, 2, 1, 2, 1)))
}

fun trap(heights: IntArray): Int {
    var result = 0

    val stack = ArrayDeque<Triple<Int, Int, Int>>() //height, maxHeight, index

    heights.forEachIndexed { idx, height ->
        var count = 0

        while (stack.isNotEmpty() && stack.last().first < height) {
            val last = stack.removeLast()

            val diffHeight = (height - last.first)
            val diffMax =
                if (last.second < height) last.second - height
                else 0

            count += diffHeight + diffMax
        }

        result += count

        val previousHeight =
            if (stack.isNotEmpty()) {
                stack.last().second
            } else {
                0
            }
        val maxHeight = Math.max(previousHeight, height)
        stack.addLast(Triple(height, maxHeight, idx))
    }

    return result
}


/**
 * Handle 80% of cases, except 3, 2, 1, 2, 1
 */
fun trap2(heights: IntArray): Int {
    var result = 0

    val stack = ArrayDeque<Pair<Int, Int>>() //height to index

    heights.forEachIndexed { idx, height ->
        var count = 0

        while (stack.isNotEmpty() && stack.last().first < height) {
            val last = stack.removeLast()

            count += (height - last.first) + (last.second - height)
        }

        result += count

        val previousHeight =
            if (stack.isNotEmpty()) {
                stack.last().second
            } else {
                0
            }
        val maxHeight = Math.max(previousHeight, height)
        stack.addLast(height to maxHeight)
    }

    return result
}
