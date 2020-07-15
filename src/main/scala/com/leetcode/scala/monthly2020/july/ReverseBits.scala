package com.leetcode.scala.monthly2020.july

/*
* Reverse bits of a given 32 bits unsigned integer.
*
* */


/*
* Input: 00000010100101000001111010011100
  Output: 00111001011110000010100101000000
  Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
*
* */

/*
* Input: 11111111111111111111111111111101
  Output: 10111111111111111111111111111111
  Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10111111111111111111111111111111.
*
* */


/*
* Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
* In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
*
* */

/*
* Follow up:
  If this function is called many times, how would you optimize it?
*
* */

/*
* Approach: Bit Manipulation
* Since, it is 32 bit signed Integer we need to iterate 32 times inorder to swap the bits
*
* Iteration for Revese bit of 10:
* 10's Binary representation(32-bit) - 0000000000000000000000000001010
*
* */

object ReverseBits {

  // Using Predefined Method
  def reverseBitsPreDefined(x: Int): Int = {
    return Integer.reverse(x)
  }

  //Using Bit Manuplation
  def reverseBits(x: Int): Int = {
    var z = 0
    for (i <- 0 until 31) {
      println(s"${z}, ${z.toBinaryString}")
      z = z | ((x >> i) & 1)
      z = z << 1
    }
    if (x < 0) {
      return z | 1
    } else {
      return z
    }
  }

  def main(args: Array[String]): Unit = {

    val num = 43261596
  }
}
