package com.leetcode.scala.monthly2020.july

/*
* Given an input string, reverse the string word by word.
*
* */

/*
* Input: "the sky is blue"
  Output: "blue is sky the"
*
* Input: "  hello world!  "
  Output: "world! hello"
  Explanation: Your reversed string should not contain leading or trailing spaces.
*
* Input: "a good   example"
  Output: "example good a"
  Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
*
* Note:
  * A word is defined as a sequence of non-space characters.
  * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
  * You need to reduce multiple spaces between two words to a single space in the reversed string.
*
*  */

/*
* Approach: Iterative Approach
* 1. Split input string " ".
* 2. Create an empty array of string.
* 3. for each word in input split array if string non empty add the string to the result array. We need to iterate through the split array in reverse order.
* 4. Use mkString(" ") to return the final output string
*
* */

object ReverseWordsInAString {
  //Functional Programming Approach - Time Complexity - O(n^5)
  def reverseWordsFP(s: String): String = {
    return s.split(" ").map(_.trim).filter(!_.isEmpty).reverse.mkString(" ")
  }

  // Without Using Split
  def reverseWordsNoSplit(s: String): String = {
    var result: Array[Char] = Array()
    var startWindow = 0
    while (startWindow < s.length) {
      var word: Array[Char] = Array()
      var endWindow = startWindow
      while (endWindow < s.length && s(endWindow) != ' ') {
        word = word :+ s(endWindow)
        endWindow += 1
      }
      if (word.nonEmpty) {
        if (endWindow != s.length - 1) word = ' ' +: word
        result = word ++ result
      }
      startWindow = endWindow + 1
    }
    result.mkString.trim
  }

  // Optimized Time
  def reverseWords(s: String): String = {
    var words = s.split(" ")
    var result: Array[String] = Array()
    for (i <- words.indices) {
      val index = words.length - 1 - i
      if (!words(index).isEmpty) result = result :+ words(index)
    }
    result.mkString(" ")
  }

  def main(args: Array[String]): Unit = {
    val input ="   Hello  World!   "
    val result = reverseWords(input)
    println(s"Result: ${result}, ${result == "World! Hello"}")
  }
}
