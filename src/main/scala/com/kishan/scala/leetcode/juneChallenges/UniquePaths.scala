package com.kishan.scala.leetcode.juneChallenges

/*
* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
  The robot can only move either down or right at any point in time.
  The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
  How many possible unique paths are there?
*
* */

/*
* Input: m = 3, n = 2
  Output: 3
  Explanation:
  From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
  1. Right -> Right -> Down
  2. Right -> Down -> Right
  3. Down -> Right -> Right
*
* Input: m = 7, n = 3
  Output: 28
*
* Constraints:
  1. 1 <= m, n <= 100
  2. It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.
*
* */

/*
* Approach: Dynamic Programming
*
* 1. For i = 0 or j = 0. Maximum possible steps will be 1.
* 2. For i >= 1 and j >= 1, we can reach from top and we can also reach from left. So it will be sum of top + left cell value.
* 
* m = 3
* n = 7
*
* Iteration:
*
* 0 -> 1 1 1  1  1  1  1
* 1 -> 1 2 3  4  5  6  7
* 2 -> 1 3 6 10 15 21 28
*
* return the last element of array which will be result
* */






object UniquePaths {

  //Using Two Dimensional Array
  def uniquePathsTwoDimensional(m: Int, n: Int): Int = {
    var dp = Array.ofDim[Int](m, n)
    for (i <- dp.indices) {
      for (j <- dp(i).indices) {
        if (i == 0 || j == 0) {
          dp(i)(j) = 1
        }
        if (i >= 1 && j >= 1) {
          dp(i)(j) = dp(i - 1)(j) + dp(i)(j - 1)
        }
      }
    }
    return dp(m - 1)(n - 1)
  }

  def main(args: Array[String]): Unit = {
    val m = 3
    val n = 7
    val result = uniquePaths(m, n)
    println(s"Result: ${result}, ${result == 28}")

    val result1 = uniquePaths(3, 2)
    println(s"Result: ${result1}, ${result1 == 3}")

  }

  //Using One Dimensional Array
  def uniquePaths(m: Int, n: Int): Int = {
    var dp = Array.ofDim[Int](n)
    for (i <- 0 until m) {
      var j = 0
      while (j < n) {
        if (i == 0 || j == 0) dp(j) = 1 else if (i >= 1) dp(j) += dp(j - 1)
        j += 1
      }
    }
    return dp(n - 1)
  }
}
