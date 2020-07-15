package com.leetcode.scala.monthly2020.july

/*
* Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
*
* Note:
  The solution set must not contain duplicate triplets.
*
* */


/*
* Given array nums = [-1, 0, 1, 2, -1, -4],
*
* A solution set is:
  [
   [-1, 0, 1],
   [-1, -1, 2]
  ]
*
* */

/*
* Approach: Two Pointer Approach or Brute Force [This approach will fail in leet code. Because of Time Complexity]
*
*
*
* */

object ThreeSum {
  def main(args: Array[String]): Unit = {
    val nums = Array(-1, 0, 1, 2, -1, -4)

    println(threeSum(nums))

  }

  //  Two Pointer Approach
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    var result: List[List[Int]] = List()
    val sorted = nums.sortBy(a => a)
    for (i <- nums.indices if !(i != 0 && sorted(i) == sorted(i - 1))) {
      var j = i + 1
      var k = nums.length - 1
      while (j < k) {
        if ((sorted(i) + sorted(j) + sorted(k)) == 0) {
          result = result :+ List(sorted(i), sorted(j), sorted(k))
          j += 1
          while (j < k && sorted(j) == sorted(j - 1)) j += 1
        } else if ((sorted(i) + sorted(j) + sorted(k)) < 0) {
          j += 1
        } else {
          k -= 1
        }
      }
    }

    return result
  }

  //Brute Force - Time Complexity O(n^3)
  def threeSumBF(nums: Array[Int]): List[List[Int]] = {
    var result: List[List[Int]] = List[List[Int]]()
    val sorted = nums.sortBy(a => a)
    val length = nums.length
    for (i <- 0 until length if !(i != 0 && sorted(i) == sorted(i - 1))) {
      for (j <- i + 1 until length if !(j != i + 1 && sorted(j) == sorted(j - 1))) {
        for (k <- j + 1 until length if !(k != j + 1 && sorted(k) == sorted(k - 1))) {
          val sum = sorted(i) + sorted(j) + sorted(k)
          if (sum == 0) result = result :+ List(sorted(i), sorted(j), sorted(k))
        }
      }
    }
    result
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var result: Array[Int] = Array()
    var left = 0
    while (left <= nums.length - 1) {
      var right = nums.length - 1
      while (left != right && right <= nums.length - 1) {
        val sum = nums(left) + nums(right)
        if (sum == target) {
          result = result :+ left
          result = result :+ right
          return result
        }
        right -= 1
      }
      left += 1
    }
    result
  }
}
