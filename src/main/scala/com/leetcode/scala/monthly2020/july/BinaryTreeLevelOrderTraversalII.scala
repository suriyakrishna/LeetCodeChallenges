package com.leetcode.scala.monthly2020.july

import com.leetcode.scala.monthly2020.june.TreeNode

import scala.collection.mutable


/*
* Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
*
* */

/*
*  For example:
   Given binary tree [3,9,20,null,null,15,7],
*
*   3
   / \
  9  20
    /  \
   15   7
*
* return its bottom-up level order traversal as:
* [
  [15,7],
  [9,20],
  [3]
  ]
*
* */

/*
* Approach: BFS - Breadth First Search
*
* 1. We have to Build Queue of Queue[TreeNode]
* 2. We will instantiate the Queue with Queue[root node]
* 3. We will dequeue the outer queue first and then we will have queue[TreeNode].
* 4. For each Queue in the outer queue we are instantiating an empty queue to store all the child nodes and an empty list to store all the Integer values from the TreeNode.
* 5. We will dequeue the inner queue and have to add the integer value to the list and we have to add the child node to the inner queue.
* 6. Once the currentElement becomes empty we will check if the new Queue which we created is empty. If it's nonEmpty we will add it to the outer Queue and the list to the result. Iteration will continue until the outer queue nonEmpty.
* 7. Finally we will return the result.
*
* */


object BinaryTreeLevelOrderTraversalII {

  def main(args: Array[String]): Unit = {
    val tree: TreeNode = new TreeNode(3, new TreeNode(9, new TreeNode(10)), new TreeNode(20, new TreeNode(15), new TreeNode(7)))
    println(tree)
    println(levelOrderBottom(tree))
  }

  def levelOrderBottom(root: TreeNode): List[List[Int]] = {
    var result: mutable.Stack[List[Int]] = mutable.Stack()
    if (root == null) return List()
    var queue: mutable.Queue[mutable.Queue[TreeNode]] = mutable.Queue()
    queue.enqueue(mutable.Queue(root))
    while (queue.nonEmpty) {
      val currentElement = queue.dequeue()
      var queue1: mutable.Queue[TreeNode] = mutable.Queue()
      var list: List[Int] = List()
      while (currentElement.nonEmpty) {
        val currentTree = currentElement.dequeue()
        val value = currentTree.value
        if (currentTree.left != null) queue1.enqueue(currentTree.left)
        if (currentTree.right != null) queue1.enqueue(currentTree.right)
        list = list :+ value
      }
      result.push(list)
      if (queue1.nonEmpty) queue.enqueue(queue1)
    }
    return result.toList
  }
}
