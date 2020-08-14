package com.leetcode.scala.monthly2020.august

/*
* Given a column title as appear in an Excel sheet, return its corresponding column number.

  For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
* */

/*
* Input: "A"
  Output: 1
*
* Input: "AB"
  Output: 28
*
* Input: "ZY"
  Output: 701
*
* Constraints:
  * 1 <= s.length <= 7
  * s consists only of uppercase English letters.
  * s is between "A" and "FXSHRXW".
* */

/*
* Approach - Iterative
*
* AB -> A is at position 1 from right and B is at position 0 from right.
* A * power(26,1) + B * power(26,0)
*
* */


object ExcelSheetColumnNumber {

  def main(args: Array[String]): Unit = {
    val testCases = Array("A", "AB", "ZY", "FXSHRXW")
    val expectedResults = Array(1, 28, 701, Int.MaxValue)
    val actualResults = testCases.map(titleToNumber)
    println(s"Result: ${actualResults.mkString(" ")}, ${actualResults.sameElements(expectedResults)}")
  }

  def titleToNumber(s: String): Int = {
    var result = 0
    for (i <- s.indices) {
      val position = s.length - 1 - i
      result += math.pow(26, position).toInt * (s(i) - 'A' + 1)
    }
    return result
  }
}
