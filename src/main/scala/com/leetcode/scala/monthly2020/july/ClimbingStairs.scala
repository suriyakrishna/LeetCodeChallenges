package com.leetcode.scala.monthly2020.july

/*
* You are climbing a stair case. It takes n steps to reach to the top.
* Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*
* */

/*
* Input: 2
  Output: 2
  Explanation: There are two ways to climb to the top.
  1. 1 step + 1 step
  2. 2 steps
*
* Input: 3
  Output: 3
  Explanation: There are three ways to climb to the top.
  1. 1 step + 1 step + 1 step
  2. 1 step + 2 steps
  3. 2 steps + 1 step
*
* Constraints:
* 1 <= n <= 45
*
*  */

/*
* Approach: Dynamic Programming/Fibonacci
*
* Refer: https://leetcode.com/articles/climbing-stairs/
*
* */


object ClimbingStairs {

  //Dynamic Programming -- Using Extra Memory and Linear time complexity
  def climbStairsDP(n: Int): Int = {
    if (n == 1) return 1
    if (n == 2) return 2
    var dp: Array[Int] = Array.fill(2 + n - 2)(0)
    dp(0) = 1
    dp(1) = 2
    for (i <- 2 until n) {
      dp(i) = dp(i - 1) + dp(i - 2)
    }
    dp.last
  }

  //Fibonacci -- Without Extra Memory and Linear time complexity
  def climbStairs(n: Int): Int = {
    var first: Int = 1
    var second: Int = 2
    if (n == 1) return first
    if (n == 2) return second
    if (n > 2) {
      for (i <- 2 until n) {
        var temp = first + second
        first = second
        second = temp
      }
    }
    second
  }

  def main(args: Array[String]): Unit = {
    val testCases = Range(1, 6)
    val expectedResult = List(1, 2, 3, 5, 8)
    val actualResult = testCases.map(a => climbStairs(a))
    println(s"Result: ${actualResult}, ${actualResult.equals(expectedResult)}")
  }
}
