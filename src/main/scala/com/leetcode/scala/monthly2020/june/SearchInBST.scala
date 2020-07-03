package com.leetcode.scala.monthly2020.june

import scala.annotation.tailrec

/*
* Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value.
* Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
*
* */

/*
* Given the tree:
        4
       / \
      2   7
     / \
    1   3

  And the value to search: 2
*
* Output:
*     2
     / \
    1   3
*
* In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
  Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
* */


/*
* Approach: Tail Recursion
* 1. We will check the root.value == val. If equal we will return the root.
* 2. If val < root.value and root.left is not null then our val should be in the left side of the root. Now we will call the function recursively.
* 3. Similarly if val > root.value and root.right is not null we will call the function recursively and our val will be in the right side of the tree.
* 4. Finally, If our val is not found we are creating a value of Type TreeNode and assigning null value to it. We will return the Empty TreeNode.
*
* */

object SearchInBST {
  @tailrec
  def searchBST(root: TreeNode, `val`: Int): TreeNode = {
    if (root.value == `val`) {
      root
    } else if (`val` < root.value && root.left != null) {
      searchBST(root.left, `val`)
    } else if (`val` > root.value && root.right != null) {
      searchBST(root.right, `val`)
    } else {
      val t: TreeNode = null
      t
    }
  }

  def main(args: Array[String]): Unit = {
    val t: TreeNode = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7))
    println("Input Binary Tree: " + t)
    println("Result Binary Tree: " + searchBST(t, 7))
  }
}
