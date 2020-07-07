package com.leetcode.scala.monthly2020.july

/*
* You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
* Given n, find the total number of full staircase rows that can be formed.
* n is a non-negative integer and fits within the range of a 32-bit signed integer.
*
* */

/*
* n = 5

  The coins can form the following rows:
  ¤
  ¤ ¤
  ¤ ¤

  Because the 3rd row is incomplete, we return 2.
*
* n = 8

  The coins can form the following rows:
  ¤
  ¤ ¤
  ¤ ¤ ¤
  ¤ ¤

  Because the 4th row is incomplete, we return 3.
*
* */

/*
* Approach: Binary Search/Mathematical
*
*
* Mathematical Approach:
* @link: https://leetcode.com/articles/arranging-coins/#
* Time Complexity: O(1)
* Space Complexity: O(1)
*
* */


object ArrangingCoins {

  //Matematical Approach
  def arrangeCoinsMath(n: Int): Int = {
    return math.sqrt((2 * n.toLong + 0.25) - 0.5).toInt
  }

  def main(args: Array[String]): Unit = {
    val n = 8
    val result = arrangeCoins(n)
    println(s"Result: ${result}, ${result == 3}")
  }

  def arrangeCoins(n: Int): Int = {
    var current = n
    var result = 0
    while (current > 0 && current > result) {
      result += 1
      current -= result
    }
    return result
  }
}
