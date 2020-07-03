package com.leetcode.scala.monthly2020.june

/*
- Write a function that reverses a string. The input string is given as an array of characters char[].
- Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
- You may assume all the characters consist of printable ascii characters.
*/

/*
Examples:

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

*/

/*
* Space complexity: O(1)
* Time complexity: O(n/2)
* */

import scala.util.control.Breaks

object reverseString {

  def main(args: Array[String]): Unit = {
    var example1: Array[Char] = Array('h', 'e', 'l', 'l', 'o')
    var result1: String = "olleh"
    println("Test 1")
    println(s"Before: ${example1.mkString("")}")
    reverseString(example1)
    println(s"After: ${example1.mkString("")}")
    println(s"Result: ${result1 == example1.mkString("")}")

    var example2: Array[Char] = Array('H', 'a', 'n', 'n', 'a', 'h')
    var result2: String = "hannaH"
    println("Test 2")
    println(s"Before: ${example2.mkString("")}")
    reverseString(example2)
    println(s"After: ${example2.mkString("")}")
    println(s"Result: ${result2 == example2.mkString("")}")

  }

  def reverseString(s: Array[Char]): Unit = {
    val length = s.length
    val breaks = new Breaks()
    breaks.breakable {
      for (i <- 0 until length) {
        val temp = s(i)
        s(i) = s(length - 1 - i)
        s(length - 1 - i) = temp
        if (i == length / 2 - 1) {
          breaks.break()
        }
      }
    }
  }
}
