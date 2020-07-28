package com.leetcode.scala.monthly2020.july

import com.leetcode.scala.monthly2020.june.TreeNode

/*
* Given inorder and postorder traversal of a tree, construct the binary tree.
*
* Note:
  You may assume that duplicates do not exist in the tree.
* */


/*
* For example, given
*
* inorder = [9,3,15,20,7]
  postorder = [9,15,7,20,3]
* Return the following binary tree:
*
*     3
     / \
    9  20
      /  \
     15   7
*
* */

object ConstructBinaryTreefromInorderAndPostorderTraversal {
  def buildTree(inorder: Array[Int], postorder: Array[Int]): TreeNode = {
    val pEnd = postorder.length
    if (pEnd == 0) return null
    return helper(0, pEnd, 0, pEnd, postorder, inorder)
  }

  def helper(pStart: Int, pEnd: Int, iStart: Int, iEnd: Int, postOrder: Array[Int], inOrder: Array[Int]): TreeNode = {
    if (pStart >= pEnd || iStart >= iEnd) return null
    var root: TreeNode = new TreeNode(postOrder(pEnd - 1))
    var it = 0
    for (i <- iStart until iEnd if postOrder(pEnd - 1) == inOrder(i)) {
      it = i
    }
    var diff = it - iStart
    root.left = helper(pStart, pStart + diff, iStart, iStart + diff, postOrder, inOrder)
    root.right = helper(pStart + diff, pEnd - 1, iStart + diff + 1, iEnd, postOrder, inOrder)
    return root
  }

  def main(args: Array[String]): Unit = {
    val inOrder = Array(9, 3, 15, 20, 7)
    val postOrder = Array(9, 15, 7, 20, 3)
    val result = buildTree(inOrder, postOrder)
    println(s"Result: ${result}")
  }
}