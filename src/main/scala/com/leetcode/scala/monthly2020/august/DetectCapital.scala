package com.leetcode.scala.monthly2020.august

/*
* Given a word, you need to judge whether the usage of capitals in it is right or not.
* We define the usage of capitals in a word to be right when one of the following cases holds:
  * All letters in this word are capitals, like "USA".
  * All letters in this word are not capitals, like "leetcode".
  * Only the first letter in this word is capital, like "Google".
* Otherwise, we define that this word doesn't use capitals in a right way.
* */

/*
* Input: "USA"
  Output: True
*
* Input: "FlaG"
  Output: False
*
* */

/*
* Approach: Iterative/Regex
*
* 1. First We will check if the first letter of string is capital or not.
* 2. We have to iterate through each character and count the number of lower case and upper case character.
* 3. If number of upper case == length of string or number of lower case == length of string we have to return true.
* 4. If upper count is 1 and first letter of the string is upper case and lowercount + 1 == length of string we have to return true.
* 5. For all other cases we will return false.
*
* */


object DetectCapital {
  def main(args: Array[String]): Unit = {
    var testCases = Array("USA", "leetcode", "UsA", "USa", "usA", "Happy")
    val expectedResults = Array(true, true, false, false, false, true)
    val actualResult = testCases.map(a => detectCapitalUse(a))
    println(s"Result: ${actualResult.mkString(" ")}, ${actualResult.sameElements(expectedResults)}")
  }

  def detectCapitalUse(word: String): Boolean = {
    var upperCount = 0
    var lowerCount = 0
    val length = word.length
    val firstElem = word.head >= 65 & word.head <= 90
    word.foreach(a => {
      if (a >= 97 & a <= 122) lowerCount += 1
      if (a >= 65 & a <= 90) upperCount += 1
    })
    if (length == upperCount) return true
    if (length == lowerCount) return true
    if (upperCount == 1 && firstElem && length == (1 + lowerCount)) {
      return true
    }
    return false
  }

  def detectCapitalUseRegex(word: String): Boolean = {
   word.matches("[A-Z]*|.[a-z]*")
  }
}
