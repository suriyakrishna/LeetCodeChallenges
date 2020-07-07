package com.leetcode.scala.monthly2020.july

/*
* The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
* Given two integers x and y, calculate the Hamming distance.
*
* */

/*
* Input: x = 1, y = 4
* Output: 2

  Explanation:
  1   (0 0 0 1)
  4   (0 1 0 0)
         ↑   ↑

  The above arrows point to positions where the corresponding bits are different.
*
*  */

/*
* Approach: Bit Manuplation
*
* 1 ^ 4 will give 0101
* we can count 1's from the binary number to get the bit count.
*
*  */


object HammingDistance {

  //Using In-built Functions
  def hammingDistanceInBuilts(x: Int, y: Int): Int = {
    Integer.bitCount(x ^ y)
  }

  def main(args: Array[String]): Unit = {
    val x = 1
    val y = 4
    val result = hammingDistance(x, y)
    println(s"Result: ${result}, ${result == 2}")
  }

  //Counting from the binary string
  def hammingDistance(x: Int, y: Int): Int = {
    (x ^ y).toBinaryString.count(a => a == '1')
  }

}
