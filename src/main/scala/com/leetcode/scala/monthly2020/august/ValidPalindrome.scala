package com.leetcode.scala.monthly2020.august

/*
* Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
*
* Note: For the purpose of this problem, we define empty string as valid palindrome.
*
*  */

/*
* Input: "A man, a plan, a canal: Panama"
  Output: true
*
* Input: "race a car"
  Output: false
*
* Constraints:
  * s consists only of printable ASCII characters.
*
* */

/*
* Approach: Iterative
* 1. Iterate through each character and form the string alphaNumeric character.
* 2. Compare the new string value with reverse value of new string.
*
* */


object ValidPalindrome {
  def main(args: Array[String]): Unit = {
    val s1 = "A man, a plan, a canal: Panama"
    val s2 = "race a car"
    val s3 = "0p"
    val testCases = Array(s1, s2, s3)
    val expectedResults = Array(true, false, false)
    val actualResults = testCases.map(isPalindrome)
    println(s"Results: ${actualResults.mkString(" ")}, ${actualResults.sameElements(expectedResults)}")
  }

  def isPalindrome(s: String): Boolean = {
    var string: StringBuilder = new StringBuilder()
    for (char <- s) {
      if ((char >= 'a' && char <= 'z') || (char >= 'A' && char <= 'Z') || (char >= '0' && char <= '9')) {
        string = string.append(char.toLower)
      }
    }
    return string.equals(string.reverse)
  }
}
