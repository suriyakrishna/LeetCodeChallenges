package com.leetcode.scala.monthly2020.july

import com.leetcode.scala.monthly2020.june.TreeNode

/* Given two binary trees, write a function to check if they are the same or not.
* Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
*
* */

/*
* Input:
*          1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

  Output: true
*
* Input:
*          1         1
          /           \
         2             2

        [1,2],     [1,null,2]

  Output: false
*
* Input:
*          1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

  Output: false
*
*  */


/*
* Approach: Recursive or Iterative
*
* 1. First, we will check both the tree are null. If yes we will return true. Else if any one of the tree is null then we have to return false.
* 2. If both are not null then we will check the value of the node and we will recursively call isSameTree for the left and right subtree.
* 3. Finally, the result will be returned
*
* */

object SameTree {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
    if (p == null && q == null) return true else if (p == null || q == null) return false
    return p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
  }

  def main(args: Array[String]): Unit = {
    val p: TreeNode = TreeNode(1, TreeNode(2), TreeNode(3))
    val q: TreeNode = TreeNode(1, TreeNode(2), TreeNode(3))
    val p1: TreeNode = TreeNode(1, TreeNode(3), TreeNode(3))
    val q1: TreeNode = TreeNode(1, TreeNode(2), TreeNode(3))
    val result = isSameTree(p, q)
    val result1 = isSameTree(p1, q1)
    println(s"Result: ${result}, ${result == true}")
    println(s"Result: ${result1}, ${result1 == false}")
  }
}
