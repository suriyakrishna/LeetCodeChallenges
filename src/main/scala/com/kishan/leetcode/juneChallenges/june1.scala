package com.kishan.leetcode.juneChallenges

// Problem Statement:

/*Invert a binary tree*/


// Input:

/*
4
/   \
2     7
/ \   / \
1   3 6   9
*/


// Output:

/*
4
/   \
7     2
/ \   / \
9   6 3   1
*/


//Definition for a binary tree node.
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object june1 {


  def invertTree(_tree: TreeNode): TreeNode = {
    if(_tree == null){
      return _tree
    }
    var tree = swapTree(_tree)
    if (tree.left != null && tree.left != null) {
      tree.left = invertTree(tree.left)
      tree.right = invertTree(tree.right)
    } else if (tree.right != null) {
      tree.right = invertTree(tree.right)
    } else if (tree.left != null) {
      tree.left = invertTree(tree.left)
    }
    return tree
  }

  def swapTree(_tree: TreeNode): TreeNode = {
    var tree = _tree
    val temp = tree.left
    tree.left = tree.right
    tree.right = temp
    tree
  }

  def printElementInTree(tree: TreeNode): Unit = {
    println(s"Node Parent: ${tree.value}")
    if (tree.right != null && tree.left != null) {
      println("Right Value is")
      printElementInTree(tree.right)
      println("Left Value is")
      printElementInTree(tree.left)
    } else if (tree.right != null) {
      println("Right Value is")
      printElementInTree(tree.right)
    } else if (tree.left != null) {
      println("Left Value is")
      printElementInTree(tree.left)
    }
  }

  def main(args: Array[String]): Unit = {
    var level_1_Left = new TreeNode(2, new TreeNode(1), new TreeNode(3))
    var level_1_Right = new TreeNode(7, new TreeNode(6), new TreeNode(9))
    var root = new TreeNode(4, level_1_Left, level_1_Right)
    //    var root = new TreeNode(2, new TreeNode(3, new TreeNode(1)))
    var root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3))
    println("Before Inverting")
    printElementInTree(root)

    println("\nAfter Inverting")
    var inverted = invertTree(root)
    printElementInTree(inverted)
  }
}
