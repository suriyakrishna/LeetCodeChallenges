package com.leetcode.scala.monthly2020.july

/*
* Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
* (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
* Find the minimum element.
* The array may contain duplicates.
*
* */

/*
* Approach: Linear/Binary Search
*
* Binary Search will the best approach.
*
*  */

object FindMinimuminRotatedSortedArrayII {
  def main(args: Array[String]): Unit = {
    val nums = Array(4, 5, 6, 6, 1, 2)
    val nums1 = Array(1, 2, 3, 4, 5)
    var result = findMin(nums)
    var result1 = findMin(nums1)
    println(s"Result: ${result}, ${result == 1}")
    println(s"Result: ${result1}, ${result1 == 1}")
  }

  //Binary Search
  def findMin(nums: Array[Int]): Int = {
    var from = 0
    var to = nums.length - 1
    while (from < to) {
      val mid = from + (to - from) / 2
      nums(mid) compareTo nums(to) match {
        case -1 => to = mid
        case 0 => to -= 1
        case _ => from = mid + 1
      }
    }
    nums(from)
  }

  //Linear Search
  def findMinLinear(nums: Array[Int]): Int = {
    if (nums.isEmpty) return 0
    var min = nums.head
    var result = nums.head
    for (i <- 1 until nums.length) {
      if (nums(i) >= result) {
        result = nums(i)
      } else {
        return nums(i)
      }
      min = min min result
    }
    min
  }

}
