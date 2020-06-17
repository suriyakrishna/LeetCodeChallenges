package com.kishan.scala.leetcode.juneChallenges

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
