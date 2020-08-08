package com.leetcode.scala.monthly2020.august

import scala.collection.mutable

/*
* Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
* Find all the elements that appear twice in this array.
* Could you do it without extra space and in O(n) runtime?
*
* */

/*
* Input:
  [4,3,2,7,8,2,3,1]
* Output:
  [2,3]
*
* */

/*
* Approach: Iterative
*
* Constraint is to solve without additional space and linear time complexity.
*
* */

object FindAllDuplicatesinanArray {

  // Using Extra Space - Our solution will fail
  def findDuplicatesES(nums: Array[Int]): List[Int] = {
    var set: mutable.HashSet[Int] = mutable.HashSet()
    var result: List[Int] = List()
    nums.foreach(a => {
      if (!set.contains(a)) set.add(a)
      else result = result :+ a
    }
    )
    return result
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(4, 3, 2, 7, 8, 2, 3, 1)
    val expectedResult = Array(2, 3)
    val actualResult = findDuplicates(nums)
    println(s"Result: ${actualResult.mkString(" ")}, ${actualResult.sameElements(expectedResult)}")
  }

  // Time Complexity - O(n) & Space Complexity - O(1)
  def findDuplicates(nums: Array[Int]): List[Int] = {
    var result: List[Int] = List()
    for (i <- nums.indices) {
      var k: Int = nums(i)
      if (k < 0) {
        k = -k
      }
      if (nums(k - 1) < 0) {
        result = result :+ k
      } else {
        nums(k - 1) = -nums(k - 1)
      }
    }
    result
  }
}
