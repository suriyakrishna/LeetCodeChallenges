package com.leetcode.scala.monthly2020.june

import scala.util.control.Breaks


/*
* Given an integer, write a function to determine if it is a power of two.
* */

/*
* Input: 1
  Output: true
  Explanation: 20 = 1
* Input: 16
  Output: true
  Explanation: 24 = 16
* Input: 218
  Output: false
* */

/*
* Explanation: Bitwise Operator
*
* Binary Representation of numbers upto 8:
* 1 -> 0001
* 2 -> 0010
* 3 -> 0011
* 4 -> 0100
* 5 -> 0101
* 6 -> 0110
* 7 -> 0111
* 8 -> 1000
*
* From above: All the number which if of power '2' has only one '1'.
*
* 4 -> 100
* -4 -> 011
* 011 + 1 -> 100
*
* 3 -> 11
* -3 -> 0
* 0 + 1 -> 1
*
* 8 -> 1000
* -8 -> 0001
* 0001 + 1 -> 1000
*
* 6 -> 110
* -6 -> 001
* 001 + 1 -> 010
* */


object PowerOfTwo {
  def main(args: Array[String]): Unit = {
    val input = 8
    println(s"Result Should Be True. Result: ${isPowerOfTwoBitWise(input)}")
    println(s"Result Should Be True. Result: ${isPowerOfTwoBitWise(6)}")
  }

  //Solution Using Predefined log and pow functions
  def isPowerOfTwoLog(n: Int): Boolean = {
    if (n == 0) {
      return false
    }
    val logValue = math.log(n) / math.log(2)
    val squareValue = math.pow(2, logValue.toInt)
    if (squareValue == n) true else false
  }

  //Using Bitwise Operator -- Time Complexity: O(1)
  def isPowerOfTwoBitWise(n: Int): Boolean = {
    if (n <= 0) {
      return false
    }
    (n & (-n)) == n
  }

  //Without using predefined Log functions. Time Complexity: O(log(n))
  def isPowerOfTwo(n: Int): Boolean = {
    if (n <= 0) {
      return false
    }
    var r = n
    var result = true
    val breaks = new Breaks()
    breaks.breakable {
      while (r > 1 && result) {
        if (r % 2 == 0) {
          r = r / 2
        } else {
          result = false
          breaks.break()
        }
      }
    }
    return result
  }
}
