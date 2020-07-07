package com.leetcode.scala.monthly2020.july

/*
* Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
* The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
* You may assume the integer does not contain any leading zero, except the number 0 itself.
*
* */

/*
* Input: [1,2,3]
  Output: [1,2,4]
  Explanation: The array represents the integer 123.
*
* Input: [4,3,2,1]
  Output: [4,3,2,2]
  Explanation: The array represents the integer 4321.
*
* */

/*
* Approach: Brute-Force
* Time Complexity: O(n), Best Case: O(1), If the last digit is less than 9
*
* 1. First we will check if the last digit value is less than 9. If yes we will add 1 to the last digit and we will return the result.
* 2. If last digit is 9 then we have to iterate through the array in reverse order and we have to check if the current element is less than 9 if yes we will add 1 and we will return the result.
  * else: we need to change the current element to 0 and we have to add 1 to next element.
  * if the first element of the array is 9 then we have to concat a new Array(1) ++ (0,0) eg: Input == [9,9]
*
* */

object PlusOne {
  def main(args: Array[String]): Unit = {
    val nums = Array(8, 9)
    val nums1 = Array(9, 9)
    val result = plusOne(nums)
    val result1 = plusOne(nums1)
    println(s"Result: [${result.mkString(", ")}], ${result.mkString(",") == "9,0"}")
    println(s"Result: [${result1.mkString(", ")}], ${result1.mkString(",") == "1,0,0"}")
  }

  def plusOne(digits: Array[Int]): Array[Int] = {
    if (digits.isEmpty) return digits
    var result = Array(digits: _*)
    if (result.last < 9) {
      result(result.length - 1) += 1
    } else {
      var i = result.length - 1
      while (i >= 0) {
        if (i != 0 && result(i) == 9) {
          result(i) = 0
        } else if (result.length != 1 && result(i) != 9) {
          result(i) += 1
          return result
        }
        if (i == 0 && digits(0) == 9) {
          result(0) = 0
          result = Array(1) ++ result
        }
        i -= 1
      }

    }
    return result
  }
}
