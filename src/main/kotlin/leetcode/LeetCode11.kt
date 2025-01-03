package leetcode

fun main() {
    val t1L = TreeNode(3)
    val t1R = TreeNode(2)
    val t1 = TreeNode(1)
    t1.left = t1L
    t1.right = t1R

    println(maxAncestorDiff2(t1))
}

fun maxAncestorDiff1(root: TreeNode?): Int {
    var result = Int.MIN_VALUE
    val stack = ArrayDeque<Int>()

    fun deepDive(branch: TreeNode?) {
        if (branch == null) return
        val value = branch.`val`

        if (stack.isNotEmpty()) {
            stack.forEach {
                val calc = Math.abs(it - value)
                if (result < calc)
                    result = calc
            }
        }

        stack.addLast(value)

        var currentSize = stack.size
        deepDive(branch.left)
        if (currentSize != stack.size) {
            stack.removeLast()
        }

        currentSize = stack.size
        deepDive(branch.right)
        if (currentSize != stack.size) {
            stack.removeLast()
        }
    }

    deepDive(root)
    return result
}

fun maxAncestorDiff2(root: TreeNode?): Int {
    var result = Int.MIN_VALUE

    fun deepDive(branch: TreeNode?): Pair<Int,Int>? {
        if (branch == null) return null
        val values = mutableListOf(branch.`val`)

        deepDive(branch.left)?.let { (lMin, lMax) ->
            values.add(lMin)
            values.add(lMax)
        }
        deepDive(branch.right)?.let { (rMin, rMax) ->
            values.add(rMin)
            values.add(rMax)
        }

        val min = values.reduce { a, b -> a.coerceAtMost(b) }
        val max = values.reduce { a, b -> a.coerceAtLeast(b) }

        result = listOf(
            result,
            Math.abs(branch.`val` - min),
            Math.abs(branch.`val` - max)
        ).reduce { a, b -> a.coerceAtLeast(b) }

        return min to max
    }

    deepDive(root)
    return result
}
