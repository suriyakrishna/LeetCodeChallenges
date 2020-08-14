package com.leetcode.scala.monthly2020.august

/*
* Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
* Note that the row index starts from 0.
*
* */

/*
* Input: 3
  Output: [1,3,3,1]
*
* */

/*
* Approach: DP - Dynamic Programming
* 0 ->     1
* 1 ->    1 1
* 2 ->   1 2 1
* 3 ->  1 3 3 1
* 4 -> 1 4 6 4 1
*
* 1. If we closely look into the above pascal triangle we can notice that first and last element of the row is always 1.
* 2. The middle element is equal to sum of the element at the same index in the previous row and element at the index-1 in the previous row.
* */


object PascalsTriangleII {
  def main(args: Array[String]): Unit = {
    val testCases = Array(3, 6)
    val expectedResults = Array(List(1, 3, 3, 1), List(1, 6, 15, 20, 15, 6, 1))
    val actualResults = testCases.map(getRow)
    println(s"Result: ${actualResults.mkString(" ")}, ${actualResults.sameElements(expectedResults)}")

  }

  def getRow(rowIndex: Int): List[Int] = {
    var array: Array[Array[Int]] = Array.ofDim(rowIndex + 1)
    for (i <- array.indices) {
      array(i) = Array.ofDim[Int](i + 1)
      for (j <- array(i).indices) {
        if (j == 0 || j == array(i).length - 1) {
          array(i)(j) = 1
        } else {
          array(i)(j) = array(i - 1)(j - 1) + array(i - 1)(j)
        }
      }
    }
    array.last.toList
  }
}
