package com.kishan.scala.leetcode.juneChallenges

/*
* Given an array with n objects colored red, white or blue,
* sort them in-place so that objects of the same color are adjacent,
* with the colors in the order red, white and blue.
*
* */

/*
* Input: [2,0,2,1,1,0]
  Output: [0,0,1,1,2,2]
* */

/*
* Follow up:
* 1. A rather straight forward solution is a two-pass algorithm using counting sort.
* 2. First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
* 3. Could you come up with a one-pass algorithm using only constant space?
*
* */


/*
* Approach: Two Pointer Approach
*
* 1. We will declare two pointer left and right.
* 2. We will also declare current pointer.
* 3. We will iterate through the array and will check if current value is 0. If 0, We will swap it with left and will increment the right and current pointer.
* 4. If current value is 2. We will swap it with right and we will decrement the right pointer position and we will not increment the current pointer position.
* 5. Other cases, we will increment the current pointer.
* 6. Finally, all the white will be in it's position.
*
* Iteration:
*         r,c       l
* Input: [2,0,2,1,1,0]
*       r,c     l
* 1 -> [0,0,2,1,1,2]
*         r,c   l
* 2 -> [0,0,2,1,1,2]
*           r,c l
* 3 -> [0,0,2,1,1,2]
*          r,c l
* 4 -> [0,0,1,1,2,2]
*           r,c,l
* 5 -> [0,0,1,1,2,2]
*             l r,c
* 6 -> [0,0,1,1,2,2]
*  */

object SortColors {
  def main(args: Array[String]): Unit = {
    var nums = Array(2, 0, 2, 1, 1, 0)
    sortColors(nums)
    println(nums.mkString)

  }

  def sortColors(nums: Array[Int]): Unit = {
    var red = 0
    var white = 0
    var blue = 0
    for (num <- nums) {
      if (num == 0) {
        red += 1
      } else if (num == 1) {
        white += 1
      } else {
        blue += 1
      }
    }
    for (i <- 0 until red) {
      nums(i) = 0
    }
    for (i <- red until red + white) {
      nums(i) = 1
    }
    for (i <- red + white until red + white + blue) {
      nums(i) = 2
    }
  }

  def sortColorsBestApproach(nums: Array[Int]): Unit = {
    var left = 0
    var right = nums.length - 1
    var current = 0
    while (current <= right) {
      if (nums(current) == 0) {
        val temp = nums(left)
        nums(left) = nums(current)
        nums(current) = temp
        left += 1
        current += 1
      } else if (nums(current) == 2) {
        val temp = nums(right)
        nums(right) = nums(current)
        nums(current) = temp
        right -= 1
      } else {
        current += 1
      }
    }
  }

}
