package leetcode

fun main() {

//    hasPathSum()
}

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    var result = false
    var lock = false

    fun deepDive(node: TreeNode?, newSum: Int) {
        if (node == null)
            return
        if (lock)
            return

        node.`val` += newSum

        if (node.left == null && node.right == null) {
            if (node.`val` == targetSum) {
                result = true
                lock = true
            }
            return
        }

        deepDive(node.left, node.`val`)
        deepDive(node.right, node.`val`)
    }

    deepDive(root, 0)

    return result
}