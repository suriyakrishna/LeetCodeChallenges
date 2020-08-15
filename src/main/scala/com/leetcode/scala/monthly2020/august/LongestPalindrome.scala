package com.leetcode.scala.monthly2020.august

import scala.collection.mutable

/*
* Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
* This is case sensitive, for example "Aa" is not considered a palindrome here.
*
* Note:
  Assume the length of given string will not exceed 1,010.
*
* */

/*
* Input:
  "abccccdd"

  Output:
  7

  Explanation:
  One longest palindrome that can be built is "dccaccd", whose length is 7.
* */


object LongestPalindrome {
  def main(args: Array[String]): Unit = {
    val testCases = Array("bb", "aaAaaaaa", "abccccdd")
    val expectedResult = Array(2, 7, 7)
    val actualResult = testCases.map(longestPalindrome)
    println(s"Result: ${actualResult.mkString(" ")}, ${actualResult.sameElements(expectedResult)}")
  }

  def longestPalindrome(s: String): Int = {
    // HashMap to store count of each characters
    var countMap: mutable.HashMap[Char, Int] = mutable.HashMap()
    s.foreach(a => {
      if (countMap.contains(a)) {
        countMap(a) += 1
      } else {
        countMap += (a -> 1)
      }
    })

    // counter to count element with odd Size
    var countOdds = 0
    countMap.foreach(a => {
      countOdds += (a._2 & 1)
    })

    // we will get the count subtracting odd count
    var count = s.length - countOdds

    // if we don't have odd size characters then return count else add 1 to the count
    if (countOdds == 0) return count else return count + 1
  }
}
