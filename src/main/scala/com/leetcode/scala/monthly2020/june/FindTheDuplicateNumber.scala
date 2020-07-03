package com.leetcode.scala.monthly2020.june

import scala.collection.mutable

/*
* Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
* prove that at least one duplicate number must exist.
* Assume that there is only one duplicate number, find the duplicate one.
*
*  */

/*
* Input: [1,3,4,2,2]
  Output: 2
*
* Input: [3,1,3,4,2]
  Output: 3
*
*
* Note:
  1. You must not modify the array (assume the array is read only).
  2. You must use only constant, O(1) extra space.
  3. Your runtime complexity should be less than O(n^2).
  4. There is only one duplicate number in the array, but it could be repeated more than once.
*
* */

/*
* Approach: Hare & Tortoise or Slow and Fast pointer
*
* */

object FindTheDuplicateNumber {

  //Using Extra Space
  def findDuplicate(nums: Array[Int]): Int = {
    var set: mutable.HashSet[Int] = mutable.HashSet()
    for (num <- nums) {
      if (set.contains(num)) {
        return num
      }
      set.add(num)
    }
    return -1
  }

  //Without Extra Space
  def findDuplicateBestApproach(nums: Array[Int]): Int = {
    var slow = nums(0)
    var fast = nums(0)
    do {
      slow = nums(slow)
      fast = nums(nums(fast))
    } while (slow != fast)
    slow = nums(0)

    while (slow != fast) {
      slow = nums(slow)
      fast = nums(fast)
    }
    return fast
  }

  def main(args: Array[String]): Unit = {
    println(findDuplicateBestApproach(Array(1,2,4,5,3,3)))
  }
}
