package com.leetcode.scala.monthly2020.july

import scala.annotation.tailrec

/*
* Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
*
* */

/*
* Input: 38
  Output: 2
  Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
               Since 2 has only one digit, return it.
*
* Follow up:
  Could you do it without any loop/recursion in O(1) runtime?
*
* */

/*
* Approach: Recursion/Iterative/Mathematical
*
*
* Mathematical approach will be O(1) Time complexity -- Digital Root
*
* For complete explanation visit.
* @link: https://leetcode.com/articles/add-digits/#
*
* */

object AddDigits {

  @tailrec
  def addDigitsRec(num: Int): Int = {
    if (num >= 0 && num <= 9) return num
    var N = num
    var sum = 0
    do {
      sum += N % 10
      N /= 10
    } while (N != 0)
    return addDigitsRec(sum)
  }

  def main(args: Array[String]): Unit = {
    val testCases = Array(0, 9, 1234, 27)
    val actualResult = testCases.map(a => addDigits(a))
    val expectedResult = Array(0, 9, 1, 9)
    println(s"Result: ${actualResult.mkString(" ")}, ${actualResult sameElements expectedResult}")
  }

  def addDigits(num: Int): Int = {
    if (num == 0) return 0
    else if (num % 9 == 0) return 9
    else return num % 9
  }
}
