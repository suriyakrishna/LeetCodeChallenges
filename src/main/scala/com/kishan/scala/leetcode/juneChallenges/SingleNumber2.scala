package com.kishan.scala.leetcode.juneChallenges

import scala.collection.mutable

/* Given a non-empty array of integers, every element appears three times except for one,
   which appears exactly once. Find that single one.
*
* */

/*
* Note:
  Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
* */

/*
* Input: [2,2,3,2]
  Output: 3
*
* Input: [0,1,0,1,0,1,99]
  Output: 99
* */

/*
* Approach: Bit Manupulation Using XOR
*
* 0 ^ 2 = 2
* 2 ^ 2 = 0
*
* 1. Declaring 3 variables ones,two and threes.
* 2. Iterating through the array.
*
* Iteration:
*
* 1 -> (2,0,0)
* 2 -> (0,2,0)
* 3 -> (1,0,2)
* 4 -> (3,0,0)
*
*
* */


object SingleNumber2 {
  def main(args: Array[String]): Unit = {
    val nums = Array(2, 2, 3, 2)
    val nums1 = Array(0, 1, 0, 1, 0, 1, 95)
    println(singleNumberBestApproach(nums))
  }

  //Using Bit Manupulation
  def singleNumberBestApproach(nums: Array[Int]): Int = {
    var ones = 0
    var twos = 0
    var threes = 0
    for (num <- nums) {
      twos |= ones & num
      ones ^= num
      threes = ones & twos
      ones &= ~threes
      twos &= ~threes
    }
    ones
  }

  //Using HashMap - Extra *Memory
  def singleNumber(nums: Array[Int]): Int = {
    var map: mutable.HashMap[Int, Int] = mutable.HashMap()
    for (num <- nums) {
      if (map.contains(num)) {
        val sum = map(num) + 1
        map += (num -> sum)
      } else {
        map += (num -> 1)
      }
    }
    for (item <- map) {
      if (item._2 == 1) return item._1
    }
    return -1
  }

}
