package com.leetcode.scala.monthly2020.june

/*
* toString Method of the Class have been override order to provide string represenation of the BST
*
* */

//Definition for a binary tree node.
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right

  override def toString: String = {
    var result = s"${this.value}"
    if (this.left != null) {
      result = s"${this.left.toString} <- " + result
    }
    if (this.right != null) {
      result = result + s" -> ${this.right.toString}"
    }
    "[" + result + "]"
  }
}

object TreeNode {
  def heightOfTree(node: TreeNode): Int = {
    if (node == null) return -1
    else return heightOfTree(node.left) + 1 max heightOfTree(node.right) + 1
  }

  def countNodes(node: TreeNode): Int = {
    if (node == null) return 0
    else return 1 + countNodes(node.left) + countNodes(node.right)
  }

  def apply(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null): TreeNode = new TreeNode(_value, _left, _right)
}
