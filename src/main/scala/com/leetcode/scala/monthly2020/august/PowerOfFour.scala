package com.leetcode.scala.monthly2020.august

/*
* Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
* */

/*
* Input: 16
  Output: true
*
* Input: 5
  Output: false
*
* Follow up: Could you solve it without loops/recursion?
*
* */

/*
* Approach: Bit Manipulation & Mathematical
*
* If number to be power of 4 the number should be power of 2 and if divided by 3 the reminder should be 1.
*
*
* A number to be power of 2 we can use bit manipulation.
  - Method 1: n & -n == n
  - Method 2: n & (n-1) == 0
*
* */


object PowerOfFour {

  // Iterartive Approach
  def isPowerOfFourIA(num: Int): Boolean = {
    if (num == 1) return true
    var n = num
    do {
      if (n % 4 != 0) return false
      n = n / 4
    } while (n > 1)
    if (n == 1) return true
    else return false
  }

  def main(args: Array[String]): Unit = {
    val inputs = Array(15, 16, 24, 256, 512, 1, -4)
    val expectedResults = Array(false, true, false, true, false, true, false)
    val actualResults = inputs.map(isPowerOfFour)
    println(s"Results: ${actualResults.mkString(" ")}, ${actualResults.sameElements(expectedResults)} ")
  }

  //Time Complexity - O(1)
  def isPowerOfFour(num: Int): Boolean = {
    (num & (num - 1)) == 0 && num % 3 == 1
  }
}
