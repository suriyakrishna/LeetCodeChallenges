package com.leetcode.scala.monthly2020.july

/*
* Implement pow(x, n), which calculates x raised to the power n (xn).
*
* */

/*
* Input: 2.00000, 10
  Output: 1024.00000
*
* Input: 2.10000, 3
  Output: 9.26100
*
* Input: 2.00000, -2
  Output: 0.25000
  Explanation: 2-2 = 1/22 = 1/4 = 0.25
*
* Note:
  * -100.0 < x < 100.0
  * n is a 32-bit signed integer, within the range [−231, 231 − 1]
*
* */

/*
* Approach:
* 1. Brute Force - BF Approach will fail in leetcode with Time Limit Exceeded error.
* 2. Exponential Approach.
*
* BRUTE FORCE => 2 ^ 8 = 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2
* EXPONENTIAL APPROACH => 2 ^ 8 = ((2 ^ 2) ^ 2) ^ 2
*
* Both can be done in Iterative as well as recursive way.
*
* If Pow is even = x*2 * (pow/2)
* If Pow is odd  = x * x ^ 2 * (pow/2) [In scala we will not get the result in decimal value for odd_num/2 - In other language we need to use (odd_number-1)/2 ]
*
* */

object Pow {

  //Predefined Function
  def myPowPF(x: Double, n: Int): Double = {
    return math.pow(x, n)
  }

  //Brute Force
  def myPowBF(x: Double, n: Int): Double = {
    var result: Double = 1d
    var powNum: Int = if (n == Int.MinValue) Int.MaxValue else if (n < 0) -1 * n else n
    for (i <- 0 until powNum) {
      result *= x
    }
    if (n == Int.MinValue) result *= x
    if (n < 0) result = 1 / result
    return result
  }

  def main(args: Array[String]): Unit = {
    val result = myPow(2, 10)
    val result1 = myPow(2, Int.MinValue)
    val result2 = myPow(2, 3)

    println(s"Result: ${result}, ${result == 1024d}")
    println(s"Result: ${result1}, ${result1 == 0d}")
    println(s"Result: ${result2}, ${result2 == 8d}")
  }

  //Exponential Approach
  def myPow(x: Double, n: Int): Double = {
    def pow(n: Int): Double = {
      if (n == 1) x
      else if (n == 0) 1
      else if (n % 2 == 0) {
        val p = pow(n / 2)
        p * p
      }
      else {
        val p = pow(n / 2)
        p * p * x
      }
    }

    if (n > 0) pow(n)
    else 1 / pow(n)
  }

}
