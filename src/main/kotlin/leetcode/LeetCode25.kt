package leetcode

fun main() {
    ArrayDeque<Int>().sum()
}

private fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    val list = mutableListOf<List<Int>>()

    fun deepDive(node: TreeNode?, innerList: ArrayDeque<Int>) {
        if (node == null)
            return

        innerList.addLast(node.`val`)

        if (node.left == null && node.right == null) {
            val sum = innerList.sum()
            if (sum == targetSum) {
                list.add(innerList.toList())
            }
            innerList.removeLast()

            return
        }

        deepDive(node.left, innerList)
        deepDive(node.right, innerList)
        innerList.removeLast()
    }

    deepDive(root, ArrayDeque())

    return list
}