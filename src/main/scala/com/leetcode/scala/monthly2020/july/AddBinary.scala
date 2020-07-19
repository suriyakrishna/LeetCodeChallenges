package com.leetcode.scala.monthly2020.july

/*
* Given two binary strings, return their sum (also a binary string).
* The input strings are both non-empty and contains only characters 1 or 0.
*
* */

/*
* Input: a = "11", b = "1"
  Output: "100"
*
* Input: a = "1010", b = "1011"
  Output: "10101"
*
* Constraints:
* 1. Each string consists only of '0' or '1' characters.
* 2. 1 <= a.length, b.length <= 10^4
* 3. Each string is either "0" or doesn't contain any leading zero.
*
* */

/*
* Approach:
*
* 1. First, we have to convert binaryString in to Array[Char] and we need to assign it to variable.
* 2. We need to make sure that both the array is of same size. If not we need to make it to same size.
* 3. We need to create an empty array of char with default value as '0'.
* 4. We need to keep track of carry digit in carry variable.
* 4. We need to iterate result.length times in revere direction and we need to count number of 1's for index of a_array, b_array and carry variable.
*   i. If three then the corresponding index value of result will become '1' and carry will be '1'.
*   ii. If two then the corresponding index value of result will become '0' and carry will be '1'.
*   iii. If 1 then the corresponding index value of result will become '1' and carry will be '0'.
* 5. At end of iteration if carry is '1', then we need add element '1' at the head of the array.
* 6. Finally, we have to convert array to string and return the result.
*
* */


object AddBinary {

  def binaryStringToInt(bin: String): Int = {
    var result = 0
    var length = bin.length
    for (i <- bin.indices) {
      result = result + (bin(i) - 48) * math.pow(2, length - 1 - i).toInt
    }
    result
  }

  def addBinary(a: String, b: String): String = {
    var aCharArray: Array[Char] = a.toCharArray
    var bCharArray: Array[Char] = b.toCharArray
    val aLength = aCharArray.length
    val bLength = bCharArray.length
    var result: Array[Char] = Array.fill(aCharArray.length)('0')
    if (aLength > bLength) {
      bCharArray = Array.fill(aCharArray.length - bCharArray.length)('0') ++ bCharArray
      result = Array.fill(aCharArray.length)('0')
    } else if (aLength < bLength) {
      aCharArray = Array.fill(bCharArray.length - aCharArray.length)('0') ++ aCharArray
      result = Array.fill(bCharArray.length)('0')
    }

    var carry = '0'
    var resultLen = result.length
    for (i <- aCharArray.indices) {
      var countOfOne = 0
      if (aCharArray(resultLen - 1 - i) == '1') countOfOne += 1
      if (bCharArray(resultLen - 1 - i) == '1') countOfOne += 1
      if (carry == '1') countOfOne += 1
      if (countOfOne == 3) {
        carry = '1'
        result(resultLen - i - 1) = '1'
      } else if (countOfOne == 2) {
        carry = '1'
      } else if (countOfOne == 1) {
        carry = '0'
        result(resultLen - i - 1) = '1'
      }
    }

    if (carry == '1') result = Array(carry) ++ result
    return result.mkString
  }

  def main(args: Array[String]): Unit = {
    val (a,b) = ("1", "111111111")
    val result = addBinary(a, b)
    val (a1,b1) = ("11", "1")
    val result1 = addBinary(a1, b1)
    val (a2,b2) = ("1010", "1011")
    val result2 = addBinary(a2, b2)
    println(s"Result: ${result}, ${result == "1000000000"}")
    println(s"Result: ${result1}, ${result1 == "100"}")
    println(s"Result: ${result2}, ${result2 == "10101"}")
  }
}
