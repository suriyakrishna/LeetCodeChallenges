package com.leetcode.scala.monthly2020.august

/*
* Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
* According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
*
* */

/*
* Input: citations = [3,0,6,1,5]
  Output: 3
  Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
               received 3, 0, 6, 1, 5 citations respectively.
               Since the researcher has 3 papers with at least 3 citations each and the remaining
               two with no more than 3 citations each, her h-index is 3.
*
* Note: If there are several possible values for h, the maximum one is taken as the h-index.
*
* */


object HIndex {
  def main(args: Array[String]): Unit = {
    val testCase = Array(3, 0, 6, 1, 5)
    val expectedResult = 3
    val actualResult = hIndex(testCase)
    println(s"Result: ${actualResult}, ${actualResult.equals(expectedResult)}")
  }

  def hIndex(citations: Array[Int]): Int = {
    val sorted = citations.sortBy(a => a)
    val length = citations.length
    var tail = length - 1
    var result = 0

    while (tail >= 0) {
      val count = length - tail
      if (sorted(tail) >= count) {
        result = count
        tail -= 1
      } else {
        return result
      }
    }
    return result
  }
}
