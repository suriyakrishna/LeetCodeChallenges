package com.leetcode.scala.monthly2020.july

import scala.collection.mutable

/*
* You are given a doubly linked list which in addition to the next and previous pointers,
* it could have a child pointer, which may or may not point to a separate doubly linked list.
* These child lists may have one or more children of their own, and so on, to produce a multilevel data structure,
* as shown in the example below.
*
* Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
*
* */

/*
* Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
  Output: [1,2,3,7,8,11,12,9,10,4,5,6]
*
* Input: head = [1,2,null,3]
  Output: [1,3,2]
  Explanation:

  The input multilevel linked list is as follows:

    1---2---NULL
    |
    3---NULL
*
* Input: head = []
  Output: []
*
* */


/*
* How multilevel linked list is represented in test case:

  We use the multilevel linked list from Example 1 above:
   1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

* The serialization of each level is as follows:
  [1,2,3,4,5,6,null]
  [7,8,9,10,null]
  [11,12,null]
*
* To serialize all levels together we will add nulls in each level to signify no node connects to the upper node of the previous level. The serialization becomes:
  [1,2,3,4,5,6,null]
  [null,null,7,8,9,10,null]
  [null,11,12,null]
*
* Merging the serialization of each level and removing trailing nulls we obtain:
  [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
*
* Constraints:
  * Number of Nodes will not exceed 1000.
  * 1 <= Node.val <= 10^5
*
* */

/*
* Approach: DFS - Depth First Search
*
* 1. First, We are Initializing an empty queue of Integers.
* 2. We have write a method dfs that will take node as an argument and check if node is empty, if node empty we will stop the dfs. else we will add the value of the node to the queue and we have to recursively check the child node and followed by the adjacent nodes.
* 3. Once dfs is completed we will be having a Queue of Integers in the same order that is required as result. But we have to return result as a Node, for that we need to build Node using the Queue of Integers.
* 4. For building a Node. We have to iterate through the queue until queue become empty.
  * a. First, Create a Node flattenHead = new Node(with the first value of the queue as the value)
  * b. Create a temp node temp = flattenHead, assign the flattenHead to the temp
  * c. We have to iterate through the each value of the queue.
  * d. For each element in the queue :
    * i. we have to build a new Node - temp1 for the element.
    * ii. We have to assign this new Node the temp.next.
    * iii. We have to assign the temp to temp1.prev
    * iv. Finally, We have assign temp = temp1
* 6. Finally, we will return the flatten head.
*
* */


object FlattenaMultilevelDoublyLinkedList {

  def main(args: Array[String]): Unit = {
    var node: Node = new Node(1)
    node.next = new Node(2)
    node.next.prev = node
    node.child = new Node(3)
    println(s"Node Before Flattening: ${node}")
    println(s"Node After Flattening: ${flatten(node)}")

  }

  def flatten(head: Node): Node = {
    var queue: mutable.Queue[Int] = mutable.Queue[Int]()

    def dfs(node: Node): Unit = {
      if (node == null) return
      queue.enqueue(node.value)
      dfs(node.child)
      dfs(node.next)
    }

    dfs(head)
    var flattenHead = new Node(queue.dequeue())
    var temp: Node = flattenHead
    while (queue.nonEmpty) {
      var temp1 = new Node(queue.dequeue())
      temp.next = temp1
      temp1.prev = temp
      temp = temp1
    }
    return flattenHead
  }
}
