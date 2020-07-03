package com.leetcode.scala.monthly2020.june

import scala.collection.mutable

/*
* Given a complete binary tree, count the number of nodes.
*
* Note:
  Definition of a complete binary tree from Wikipedia:
  In a complete binary tree every level, except possibly the last, is completely filled,
  and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
* */


/*
* Input:
      1
     / \
    2   3
   / \  /
  4  5 6

  Output: 6
*
* */


/*
* Approach: BFS - Breadth First Search or Recursive
*
* 1. Build a mutable queue. Add root the queue.
* 2. We have to dequeue the queue when queue is not empty and we have to increment the count by 1 for every dequeue.
* 3. If node.left or node.right is not null we will enqueue the node.
* 4. Finally we will return the count.
*  */


object CountCompleteTreeNode {

  def main(args: Array[String]): Unit = {
    val tree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6)))
    val noOfNodes = countNodesRec(tree)
    println(s"Result: ${noOfNodes}, ${noOfNodes == 6}")
  }


  def countNodes(root: TreeNode): Int = {
    if (root == null) return 0
    var queue: mutable.Queue[TreeNode] = mutable.Queue()
    queue.enqueue(root)
    var count = 0
    while (queue.nonEmpty) {
      val currentTree = queue.dequeue()
      count += 1
      if (currentTree.left != null) queue.enqueue(currentTree.left)
      if (currentTree.right != null) queue.enqueue(currentTree.right)
    }
    return count
  }

  def countNodesRec(root: TreeNode, count: Int = 0): Int = {
    if (root == null) return 0
    var count = 1
    if (root.left != null) count += countNodesRec(root.left)
    if (root.right != null) count += countNodesRec(root.right)
    return count
  }


}
