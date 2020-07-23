package com.leetcode.scala.monthly2020.july

import com.leetcode.scala.monthly2020.june.TreeNode

import scala.collection.mutable

/*
* Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
* */

/*
* For example:
  Given binary tree [3,9,20,null,null,15,7],
*     3
     / \
    9  20
      /  \
    15   7
*
* Return it as:
*  [
    [3],
    [20,9],
    [15,7]
   ]
* */


/*
* Approach: BFS - Breadth First Search
*
* This is same as level order traversal. But catch is when ever we reach level which is of even number we need to reverse the list.
*
* 1. Check if the root is null or not. If null return empty list.
* 2. We need to create a Queue of Queue[TreeNode]. We will hold all the node at a level in Inner Queue and Outer queue will hold all the inner queues.
* 3. We need to enqueue the outer queue with the Queue[RootNode] -- To Start with BFS.
* 4. We have to iterate through the outer queue until it becomes empty.
* 5. While iterating through the outer queue for every iteration we will get queue of nodes. For every queue of nodes we will get all of its child node at that level and we will enqueue them in a new queue and all the node value to a new list.
* 6. After adding all the child nodes we will add the new queue to outer queue and list to the result.
* 7. Finally, if the outer queue becomes empty we will return the result.
*
* */

object BinaryTreeZigzagLevelOrderTraversal {
  def main(args: Array[String]): Unit = {
    val tree = TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))
    val tree1 = TreeNode(1, TreeNode(2, TreeNode(4)), TreeNode(3, null, TreeNode(5)))
    val result = zigzagLevelOrder(tree)
    val result1 = zigzagLevelOrder(tree1)
    println(s"Result: ${result}, ${result.toString == "List(List(3), List(20, 9), List(15, 7))"}")
    println(s"Result: ${result1}, ${result1.toString == "List(List(1), List(3, 2), List(4, 5))"}")
  }

  def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
    var result: List[List[Int]] = List()
    if (root == null) return result
    var queue: mutable.Queue[mutable.Queue[TreeNode]] = mutable.Queue()
    queue.enqueue(mutable.Queue(root))
    while (queue.nonEmpty) {
      var levelQueue = queue.dequeue()
      var list: List[Int] = List()
      var newQueue: mutable.Queue[TreeNode] = mutable.Queue()
      while (levelQueue.nonEmpty) {
        val currentTree = levelQueue.dequeue()
        if (result.length % 2 == 0) {
          list = list :+ currentTree.value
        } else {
          list = currentTree.value +: list
        }

        if (currentTree.left != null) newQueue.enqueue(currentTree.left)
        if (currentTree.right != null) newQueue.enqueue(currentTree.right)
      }
      if (newQueue.nonEmpty) {
        queue.enqueue(newQueue)
      }
      result = result :+ list
    }
    return result
  }
}
