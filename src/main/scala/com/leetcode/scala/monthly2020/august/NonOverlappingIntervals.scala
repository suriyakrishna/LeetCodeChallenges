package com.leetcode.scala.monthly2020.august

import scala.math.Ordering

/*
* Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
*
* */

/*
* Input: [[1,2],[2,3],[3,4],[1,3]]
  Output: 1
  Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
*
* Input: [[1,2],[1,2],[1,2]]
  Output: 2
  Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
*
* Input: [[1,2],[2,3]]
  Output: 0
  Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
*
* Note:
  * You may assume the interval's end point is always bigger than its start point.
  * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
  *
*  */


object NonOverlappingIntervals {
  def main(args: Array[String]): Unit = {
    val testCases = Array(Array(Array(1, 2)),
      Array(Array(1, 2), Array(2, 3), Array(3, 4), Array(1, 3)),
      Array(Array(1, 2), Array(2, 3)))
    val expectedResult = Array(0, 1, 0)
    val actualResult = testCases.map(eraseOverlapIntervals)
    println(s"Result: ${actualResult.mkString(" ")}, ${actualResult.sameElements(expectedResult)}")
  }

  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    // If the intervals length is less than 2 return 0
    if (intervals.length < 2) return 0

    // Sort By Start of the Interval
    val sorted = intervals.sortBy(a => a(0))(Ordering.Int)

    // Get the end of the First Interval
    var end = sorted(0)(1)

    // Declare counter
    var count = 0

    for (i <- 1 until sorted.length) {
      // Check if current Index start is less than end. If yes we have to increment counter by 1 and end will be minimum of end and end of the current index - Else change the end to current Index end
      if (sorted(i)(0) < end) {
        end = end min sorted(i)(1)
        count += 1
      } else {
        end = sorted(i)(1)
      }
    }
    // return the counter
    return count
  }
}
