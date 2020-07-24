package com.leetcode.scala.monthly2020.july

import scala.collection.mutable


/*
* Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly
* twice. Find the two elements that appear only once.
*
* */

/*
* Input:  [1,2,1,3,2,5]
  Output: [3,5]
*
* Note:
  1. The order of the result is not important. So in the above example, [5, 3] is also correct.
  2. Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity.
*
* */

/*
* Approach: Bit Manipulation
*
* */

object SingleNumberIII {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 2, 1, 3, 2, 5)
    val result = singleNumber(nums)
    println(s"Result: ${result.mkString(" ")}, ${result.mkString(" ") == "5 3"}")
  }

  //Without Extra Space
  def singleNumber(nums: Array[Int]): Array[Int] = {
    var num1: Int = 0
    for (num <- nums) {
      num1 ^= num
    }
    num1 &= -num1
    var result = Array.fill[Int](2)(0)
    for (num <- nums) {
      if ((num1 & num) == 0) {
        result(0) ^= num
      } else {
        result(1) ^= num
      }
    }
    result
  }


  // Using Extra Space
  // Time Complexity - O(n)
  // Space Complexity - O(n)

  def singleNumberES(nums: Array[Int]): Array[Int] = {
    val set: mutable.HashSet[Int] = mutable.HashSet()
    for (num <- nums) {
      if (set.contains(num)) {
        set.remove(num)
      } else {
        set.add(num)
      }
    }
    set.toArray
  }
}
