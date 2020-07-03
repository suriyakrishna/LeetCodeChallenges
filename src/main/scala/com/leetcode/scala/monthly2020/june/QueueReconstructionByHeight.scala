package com.leetcode.scala.monthly2020.june

import java.util

import scala.collection.JavaConverters._

/*
* Problem Statement:
*
* Suppose you have a random list of people standing in a queue.
* Each person is described by a pair of integers (h, k),
* where h is the height of the person and k is the number of people in front of this person
* who have a height greater than or equal to h.
* Write an algorithm to reconstruct the queue.
*/

/*
* Input:
  [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

* Output:
  [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/

/*
* Approach:
* 1. We have to sort the person based on their height in descending order and the number of people in front of them in ascending order.
* 2. We have to create a empty Linked List.
* 3. For each person in the sorted list. The second value will dentoes their Index.
* 4. We have to insert the person into LinkedList based on their Index.
* 5. Finally we will return the result
*
* */


/*
* Eg: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
*
* Sorting Based on Height In Descending Order:
* [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
*
* Iteration Results:
* 1 -> [[7,0]]
* 2 -> [[7,0], [7,1]]
* 3 -> [[7,0], [6,1], [7,1]]
* 4 -> [[5,0], [7,0], [6,1], [7,1]]
* 5 -> [[5,0], [7,0], [5,2], [6,1], [7,1]]
* 6 -> [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*
* */


object QueueReconstructionByHeight {

  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
    var emptyLinkedList = new util.LinkedList[Array[Int]]()
    for (item <- people.sortBy(a => (a(0), a(1)))(Ordering.Tuple2(Ordering.Int.reverse, Ordering.Int))) {
      emptyLinkedList.add(item(1), item)
    }
    emptyLinkedList.asScala.toArray
  }

  def main(args: Array[String]): Unit = {
    val input: Array[Array[Int]] = Array(Array(7, 0), Array(4, 4), Array(7, 1), Array(5, 0), Array(6, 1), Array(5, 2))
    println(reconstructQueue(input).map(_.toList).toList)
  }
}
