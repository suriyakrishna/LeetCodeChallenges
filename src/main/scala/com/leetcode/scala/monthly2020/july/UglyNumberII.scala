package com.leetcode.scala.monthly2020.july

/*
* Write a program to find the n-th ugly number.
* Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
*
* */

/*
* Input: n = 10
  Output: 12
  Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
*
* Note:
  * 1 is typically treated as an ugly number.
  * n does not exceed 1690.
*
* Hints:
* @link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3380/
* */

/*
* Approach: Dynamic Programming
*
* 1. Create an empty list or array and add 1 to the list since 1 is ugly.
* 2. Instantiate 3 variables i, j, and k with 0
* 3. We have to iterate until list.size > n.
* 4. For each iteration we will add the min value of (i*2, j*3, l*5) to the list and
  * if i * 2 == minValue we will increment i by 1
  * if i * 3 == minValue we will increment j by 1
  * if i * 5 == minValue we will increment k by 1
* 5. Finally we will return the last value from the list which will be our result
*
* Iteration: for n = 11
*
*  1 -> List(1) :+ min(2, 3, 5) and i=1, j=0, k=0
*  2 -> List(1, 2) :+ min(4, 3, 5) and i=1, j=1, k=0
*  3 -> List(1, 2, 3) :+ min(4, 6, 5) and i=2, j=1, k=0
*  4 -> List(1, 2, 3, 4) :+ min(6, 6, 5) and i=2, j=1, k=1
*  5 -> List(1, 2, 3, 4, 5) :+ min(6, 6, 10) and i=3, j=2, k=1
*  6 -> List(1, 2, 3, 4, 5, 6) :+ min(8, 9, 10) and i=4, j=2, k=1
*  7 -> List(1, 2, 3, 4, 5, 6, 8) :+ min(10, 9, 10) and i=4, j=3, k=1
*  8 -> List(1, 2, 3, 4, 5, 6, 8, 9) :+ min(10, 12, 10) and i=5, j=3, k=2
*  9 -> List(1, 2, 3, 4, 5, 6, 8, 9, 10) :+ min(12, 12, 15) and i=6, j=4, k=2
* 10 -> List(1, 2, 3, 4, 5, 6, 8, 9, 10, 12) :+ min(16, 15, 15) and i=6, j=5, k=3
*
* Last value is 15.
* */


object UglyNumberII {

  def main(args: Array[String]): Unit = {
    val n = 11
    var result = nthUglyNumber(n)
    println(s"Result: ${result}, ${result == 15}")
  }

  def nthUglyNumber(n: Int): Int = {
    if (n <= 0) return 0
    var list: List[Int] = List(1)
    var i: Int = 0
    var j: Int = 0
    var k: Int = 0

    while (list.size < n) {
      val m2 = list(i) * 2
      val m3 = list(j) * 3
      val m5 = list(k) * 5
      val min = m2 min m3 min m5
      list = list :+ min
      if (min == m2) i += 1
      if (min == m3) j += 1
      if (min == m5) k += 1
    }
    return list.last
  }
}
