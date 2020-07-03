package com.leetcode.scala.monthly2020.june

/*
* Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
* */


/*
* Input: n = 12
  Output: 3
  Explanation: 12 = 4 + 4 + 4.
*
* Input: n = 13
  Output: 2
  Explanation: 13 = 4 + 9.
*
* */

/*
* Approach: Dynamic Programming
*
* Assume we want to find the numSquares for 13. Below will be iterations.
* Intially for each value the value it self will be the possible value. i.e for 4 = 1^2 + 1^2 + 1^2 + 1^2
*
* dp = [0,0,0,0,0,0,0,0,0,0,0,0,0,0]
* dp(0) -> 0
* dp(1) -> 1 and inner loop dp(1) -> min(dp(1), 1 + dp(1 - 1*1)) -> 1
* dp(2) -> 2 and inner loop dp(2) -> min(dp(2), 1 + dp(2 - 1*1)) -> 2
* dp(3) -> 3 and inner loop dp(3) -> min(dp(3), 1 + dp(3 - 1*1)) -> 3
* dp(4) -> 4 and inner loop dp(4) -> min(dp(4), 1 + dp(4 - 1*1)) -> 4, dp(4) -> min(dp(4), 1 + dp(4 - 2*2)) -> 1
* dp(5) -> 5 and inner loop dp(5) -> min(dp(5), 1 + dp(5 - 1*1)) -> 2, dp(5) -> min(dp(5), 1 + dp(5 - 2*2)) -> 2
* dp(6) -> 6 and inner loop dp(6) -> min(dp(6), 1 + dp(6 - 1*1)) -> 3, dp(6) -> min(dp(6), 1 + dp(6 - 2*2)) -> 3
* dp(7) -> 7 and inner loop dp(7) -> min(dp(7), 1 + dp(7 - 1*1)) -> 4, dp(7) -> min(dp(7), 1 + dp(7 - 2*2)) -> 4
* dp(8) -> 8 and inner loop dp(8) -> min(dp(8), 1 + dp(8 - 1*1)) -> 5, dp(8) -> min(dp(8), 1 + dp(8 - 2*2)) -> 2
* dp(9) -> 9 and inner loop dp(9) -> min(dp(9), 1 + dp(9 - 1*1)) -> 3, dp(9) -> min(dp(9), 1 + dp(9 - 2*2)) -> 3, , dp(9) -> min(dp(9), 1 + dp(9 - 3*3)) -> 1
* dp(10) -> 10 and inner loop dp(10) -> min(dp(10), 1 + dp(10 - 1*1)) -> 2, dp(10) -> min(dp(10), 1 + dp(10 - 2*2)) -> 2, , dp(10) -> min(dp(10), 1 + dp(10 - 3*3)) -> 2
* dp(11) -> 11 and inner loop dp(11) -> min(dp(11), 1 + dp(11 - 1*1)) -> 3, dp(11) -> min(dp(11), 1 + dp(11 - 2*2)) -> 3, , dp(11) -> min(dp(11), 1 + dp(11 - 3*3)) -> 3
* dp(12) -> 12 and inner loop dp(12) -> min(dp(12), 1 + dp(12 - 1*1)) -> 4, dp(12) -> min(dp(12), 1 + dp(12 - 2*2)) -> 3, , dp(12) -> min(dp(12), 1 + dp(12 - 3*3)) -> 3
* dp(13) -> 13 and inner loop dp(13) -> min(dp(13), 1 + dp(13 - 1*1)) -> 4, dp(13) -> min(dp(13), 1 + dp(13 - 2*2)) -> 2, , dp(12) -> min(dp(12), 1 + dp(13 - 3*3)) -> 2
*
*
* Finally, we will return the n'th value of the dp which will be the result
* */


object PerfectSquares {
  def main(args: Array[String]): Unit = {
    val result = numSquares(13)
    println(s"Result: ${result}, ${result == 2}")
  }

  def numSquares(n: Int): Int = {
    var dp: Array[Int] = Array.ofDim[Int](n + 1)
    for (i <- dp.indices) {
      dp(i) = i
      var j = 1
      while (j * j <= i) {
        dp(i) = math.min(dp(i), 1 + dp(i - j * j))
        j += 1
      }
    }
    return dp(n)
  }
}
