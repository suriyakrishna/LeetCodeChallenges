package com.leetcode.scala.monthly2020.june

/*
* Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
* An example is the root-to-leaf path 1->2->3 which represents the number 123.
*
* Find the total sum of all root-to-leaf numbers.
*
* Note: A leaf is a node with no children.
*
* */

/*
* Input: [1,2,3]
      1
     / \
    2   3
  Output: 25

  Explanation:
  * The root-to-leaf path 1->2 represents the number 12.
  * The root-to-leaf path 1->3 represents the number 13.
  * Therefore, sum = 12 + 13 = 25.
*
* Input: [4,9,0,5,1]
      4
     / \
    9   0
   / \
  5   1
  Output: 1026

  Explanation:
  * The root-to-leaf path 4->9->5 represents the number 495.
  * The root-to-leaf path 4->9->1 represents the number 491.
  * The root-to-leaf path 4->0 represents the number 40.
  * Therefore, sum = 495 + 491 + 40 = 1026.
*
* */


/*
* Approach: Recursive or Depth First Search
*
* Initially num and sum will be 0
* 4 = 4
* 4 -> 0 = 40, sum = 40
* 4 -> 9 -> 5 = 495, sum = 40 + 495
* 4 -> 9 -> 1 = 491, sum = 40 +  495 + 491
*
* We will recursively go through the nodes when we reach the leaf we will add the current num to sum
*
* */


object SumRootToLeafNumbers {

  //Using List - It will consume extra space and extra time
  def sumNumbersRec(root: TreeNode): Int = {
    if (root == null) return 0
    var list: List[List[Int]] = List()

    def rec(node: TreeNode, temp: List[Int] = List()): Unit = {
      var l = temp
      if (node != null) l = l :+ node.value
      if (node.left == null && node.right == null) {
        list = list :+ l
      }
      if (node.left != null) {
        rec(node.left, l)
      }
      if (node.right != null) {
        rec(node.right, l)
      }
    }

    rec(root)
    return list.map(_.mkString.toInt).sum
  }

  def main(args: Array[String]): Unit = {
    val tree = new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0))
    val result = sumNumbers(tree)
    println(s"Result: ${result}, ${result == 1026}")
  }

  //Without Using Extra Space
  def sumNumbers(root: TreeNode): Int = {
    if (root == null) return 0
    var sum: Int = 0

    def formNumber(node: TreeNode, num: Int = 0): Unit = {
      var currSum = num
      if (node != null) currSum = currSum * 10 + node.value
      if (isLeaf(node)) sum += currSum
      if (node.left != null) {
        formNumber(node.left, currSum)
      }
      if (node.right != null) {
        formNumber(node.right, currSum)
      }
    }

    formNumber(root)
    return sum
  }

  def isLeaf(node: TreeNode): Boolean = {
    return node.left == null && node.right == null
  }


}
