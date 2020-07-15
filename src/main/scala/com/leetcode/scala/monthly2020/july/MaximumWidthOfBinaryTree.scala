package com.leetcode.scala.monthly2020.july

import com.leetcode.scala.monthly2020.june.TreeNode

import scala.collection.mutable

/*
* Given a binary tree, write a function to get the maximum width of the given tree.
* The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree,
* but some nodes are null.
*
* The width of one level is defined as the length between the end-nodes
* (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes
* are also counted into the length calculation.
*
* */

/*
* Input:

             1
           /   \
          3     2
         / \     \
        5   3     9

  Output: 4
  Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
*
* Input:

            1
           /
          3
         / \
        5   3

  Output: 2
  Explanation: The maximum width existing in the third level with the length 2 (5,3).
*
* Input:

            1
           / \
          3   2
         /
        5

  Output: 2
  Explanation: The maximum width existing in the second level with the length 2 (3,2).
*
* Input:

            1
           / \
          3   2
         /     \
        5       9
       /         \
      6           7
  Output: 8
  Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
*
* */

/*
* Approach: DFS
*
* 1. We have to use maxWidth variable to store the maximum width value.
* 2. We have use HashMap and we have to keep track of the left most node's position for each Level
  * eg:
  *        1 Position(0)
  *       / \
  *   null    2 position(1)
  *         /  \
  *        4    5
  *
  * For the above Tree, after all Iteration our leftPosition HashMap will look like:
  *
  * For Level 0 (Root) 1's position will be 0
  * For Level 0 + 1 null's position will be 0 (2 * prev position), 2's position will be 1 (2 * prev position + 1)
  * For Level 1 + 1 4's position will be (2 * prev position(1)) = 2 and 5's position will be (2 * 1  + 1) = 3
  *
  * Map(0 -> 0, 1 -> 1, 2 -> 2), We Store the left most position of the each level.
  *
  * Explanation:
      * For Level 0 -> Node(1) is the left most node and it's position is 0
      * For Level 1 -> Node(2) is the left most node and it's position is 1. We will not consider the null which is at the left.
      * For Level 2 -> Node(4) is the left most node and it's position is 2. We have 2 null's at the left ignoring those null's position our left most node is 2.
      *
  *
* 3. Whenever we encounter both left and right node as null we will calculate the maximum width and update the maximum with value.
* 4. Finally we will return maximum width value.
*
* Note: We will put the left position only once in the map for each level. We will not update the left most position if we have the leftmost position value in the map.
*
* */


object MaximumWidthOfBinaryTree {

  def main(args: Array[String]): Unit = {
    val root = TreeNode(1, TreeNode(3, TreeNode(5), TreeNode(3)), TreeNode(2, null, TreeNode(9)))
    val root1 = TreeNode(1, TreeNode(3, TreeNode(5, TreeNode(6))), TreeNode(2, null, TreeNode(9, null, TreeNode(7))))
    val root2 = TreeNode(1, null, TreeNode(2, TreeNode(4), TreeNode(5)))
    val result = widthOfBinaryTree(root)
    val result1 = widthOfBinaryTree(root1)
    val result2 = widthOfBinaryTree(root2)
    println(s"Result: ${result}, ${result == 4}")
    println(s"Result: ${result1}, ${result1 == 8}")
    println(s"Result: ${result2}, ${result2 == 2}")
  }

  //Using - Depth First Search
  def widthOfBinaryTree(root: TreeNode): Int = {
    var maxWidth: Int = 0
    var leftMostPosition: mutable.HashMap[Int, Int] = mutable.HashMap()

    def dfs(node: TreeNode, depth: Int, position: Int): Unit = {
      if (node == null) return
      leftMostPosition.getOrElseUpdate(depth, position)
      maxWidth = maxWidth max (position - leftMostPosition(depth) + 1)
      dfs(node.left, 1 + depth, position * 2)
      dfs(node.right, 1 + depth, position * 2 + 1)
    }

    dfs(root, 0, 0)
    return maxWidth
  }

  def usingBFS(root: TreeNode): Int = {
    var queue: mutable.Queue[(TreeNode, Int, Int)] = mutable.Queue()
    var maxWidth = 0
    queue.enqueue((root, 0, 0))
    while (queue.nonEmpty) {

    }
    return maxWidth
  }

}
