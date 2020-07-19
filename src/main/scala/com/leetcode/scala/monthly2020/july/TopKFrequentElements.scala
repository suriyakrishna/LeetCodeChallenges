package com.leetcode.scala.monthly2020.july

import scala.collection.mutable

/*
* Given a non-empty array of integers, return the k most frequent elements.
*
* */

/*
* Input: nums = [1,1,1,2,2,3], k = 2
  Output: [1,2]
*
* Input: nums = [1], k = 1
  Output: [1]
*
*
* Note:
  * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
  * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
  * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
  * You can return the answer in any order.
*
* */

/*
* Approach:
*
* 1. We have to iterate through the array and have to count the num of repetitions for the number. Time Complexity O(n)
* 2. We have to iterate through the map and for each pair we need to insert the element into the priority queue (Ordering of priority queue will be based on the count of the element).
* 3. For k times we need to dequeue the queue to get our element and we need to add the element to an result array.
* 4. We will return the result.
*
*  */


object TopKFrequentElements {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 2, 2, 3, 3, 3, 4, 4, 4)
    val k = 3
    val result = topKFrequent(nums, k)
    val nums1 = Array(1, 2)
    val k1 = 2
    val result1 = topKFrequent(nums1, k1)
    val nums2 = Array(1)
    val k2 = 1
    val result2 = topKFrequent(nums2, k2)
    val nums3 = Array[Int]()
    val k3 = 1
    val result3 = topKFrequent(nums3, k3)
    println(s"Result: ${result.mkString(" ")}, ${result.mkString(" ") == "4 3 2"}")
    println(s"Result: ${result1.mkString(" ")}, ${result1.mkString(" ") == "2 1"}")
    println(s"Result: ${result2.mkString(" ")}, ${result2.mkString(" ") == "1"}")
    println(s"Result: ${result2.mkString(" ")}, ${result3.mkString(" ") == ""}")
  }

  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    if (nums.isEmpty || k > nums.length) return Array[Int]()
    var map: mutable.HashMap[Int, Int] = mutable.HashMap()
    nums.foreach(a => {
      map += (a -> (map.getOrElse(a, 0) + 1))
    })

    var queue: mutable.PriorityQueue[(Int, Int)] = mutable.PriorityQueue()(Ordering.by(a => a._2))
    map.foreach(a => {
      queue.enqueue((a._1, a._2))
    })

    var result: Array[Int] = Array()
    for (i <- 0 until k if queue.nonEmpty) {
      result = result :+ queue.dequeue()._1
    }
    return result
  }
}
