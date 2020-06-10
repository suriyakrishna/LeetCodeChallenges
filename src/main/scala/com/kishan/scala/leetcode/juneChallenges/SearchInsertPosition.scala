package com.kishan.scala.leetcode.juneChallenges

/*
* Given a sorted array and a target value, return the index if the target is found.
* If not, return the index where it would be if it were inserted in order.
*
* You may assume no duplicates in the array.
* */

/*
* Input: [1,3,5,6], 5
  Output: 2
* Input: [1,3,5,6], 2
  Output: 1
* Input: [1,3,5,6], 7
  Output: 4
* Input: [1,3,5,6], 0
  Output: 0
* */

/*
* Approach:
*
* Linear Search Approach:
*
* 1. We will check if the element is lesser than or equal to the first element. If yes we will return 0. Time Complexity: O(1)
* 2. We will check if the element is equal to the last element. If yes we will return length - 1. Time Complexity: O(1)
* 3. We will check if the element is greater than the last element. If yes we will return the length of the array. Time Complexity: O(1)
* 4. Else we will iterate through the array and will check if the element is less than or equal to the current element. If yes we will return the index of the current element. Time Complexity: O(n)
*
*
* Binary Search Algorithm:
*
* First 3 cases from above will be applicable here.
* For the last case instead of iterating through the array. We will use Binary Search Algorithm to do that. Time Complexity: O(log(n))
*
*
* */


object SearchInsertPosition {

  def main(args: Array[String]): Unit = {
    val nums = Array(1, 3, 5, 6)
    val target = 2
    val result = searchInsertBinary(nums, target)
    println(result, result == 1)
  }

  //Using Binary Search
  def searchInsertBinary(nums: Array[Int], target: Int): Int = {
    val length = nums.length
    var counter = 0
    if (target <= nums.head) {
      return 0
    } else if (target == nums.last) {
      return nums.length - 1
    } else if (target > nums.last) {
      return nums.length
    } else {
      return binarySearch(nums, target)
    }
  }

  //Binary Search Algorithm
  def binarySearch(arr: Array[Int], target: Int): Int = {
    var head = 0
    var tail = arr.length - 1
    while (head < tail) {
      val mid = head + (tail - head) / 2
      if (target == arr(mid)) {
        return mid
      }
      if (target < arr(mid)) {
        tail = mid
      } else {
        head = mid + 1
      }
    }
    if (target < arr(tail)) tail else head
  }

  //Linear Search Algorithm
  def searchInsert(nums: Array[Int], target: Int): Int = {
    val length = nums.length
    var counter = 0
    if (target <= nums.head) {
      return 0
    } else if (target == nums.last) {
      return nums.length - 1
    } else if (target > nums.last) {
      return nums.length
    }
    for (i <- nums.indices) {
      if (target <= nums(i)) {
        return i
      }
    }
    return -1
  }
}
