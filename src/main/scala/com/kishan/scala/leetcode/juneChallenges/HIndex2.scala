package com.kishan.scala.leetcode.juneChallenges

import scala.util.control.Breaks

/*
* Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
  According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have
  at least h citations each, and the other N − h papers have no more than h citations each."
*
* */

/*
* Input: citations = [0,1,3,5,6]
  Output: 3
  Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
               received 0, 1, 3, 5, 6 citations respectively.
               Since the researcher has 3 papers with at least 3 citations each and the remaining
               two with no more than 3 citations each, her h-index is 3.
*
* */

/*
* Approach:
* 1. We have to iterate through the list in reverse order [If list is not sorted we have to sort the list in ascending order first].
* 2. Will check if the current element is greater than or equal to count. If not we will continue the iteration.
* 3. If not we have to break the loop and return the result.
*
* */


object HIndex2 {

  def main(args: Array[String]): Unit = {
    val citations = Array(0, 1, 3, 5, 6)
    val result = hIndex(citations)
    println(s"Result: ${result}, ${result == 3}")
  }

  def hIndex(citations: Array[Int]): Int = {
    val length = citations.length
    var result = 0
    var tail = length - 1
    val breaks = new Breaks
    breaks.breakable {
      while (tail >= 0) {
        var count = length - tail
        if (citations(tail) >= count) {
          result = count
          tail -= 1
        } else {
          breaks.break()
        }
      }
    }
    return result
  }
}
