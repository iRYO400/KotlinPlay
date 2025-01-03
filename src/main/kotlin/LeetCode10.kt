fun main() {
    val t1L = TreeNode(3)
    val t1R = TreeNode(2)
    val t1 = TreeNode(1)
    t1.left = t1L
    t1.right = t1R

    println(inorderTraversal(t1))
    println(inorderTraversal2(t1))
}


fun inorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }

    val value = root.`val`

    return inorderTraversal(root.left) + listOf(value) + inorderTraversal(root.right)
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun inorderTraversal2(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun inorder(branch: TreeNode?) {
        if (branch == null) {
            return
        }

        inorder(branch.left)
        result.add(branch.`val`)
        inorder(branch.right)
    }

    inorder(root)
    return result
}
