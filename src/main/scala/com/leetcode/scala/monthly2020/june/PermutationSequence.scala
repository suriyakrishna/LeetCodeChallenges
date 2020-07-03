package com.leetcode.scala.monthly2020.june

/*
* The set [1,2,3,...,n] contains a total of n! unique permutations.
  By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

    "123"
    "132"
    "213"
    "231"
    "312"
    "321"

  Given n and k, return the kth permutation sequence.
* Note:
*   Given n will be between 1 and 9 inclusive.
*   Given k will be between 1 and n! inclusive.
* */


/*
* Input: n = 3, k = 3
  Output: "213"
*
* Input: n = 4, k = 9
  Output: "2314"
* */


/*
* Approach - 1: [This method will be slow because we are calculating all the possible permutations]
* 1. First we are creating a Range out of n.
* 2. We use permutations method under Range object to get the permutations.
* 3. We are dropping all the element upto k-1.
* 4. Take next element from the Range.
* 5. Convert list of integers to string using mkString method.
* 6. return the string.
*
* */


object PermutationSequence {

  def main(args: Array[String]): Unit = {
    val result = getPermutation(3, 3)
    println(s"Result: ${result}, ${result == "213"}")
    val result1 = getPermutation(4, 4)
    println(s"Result: ${result1}, ${result1 == "1342"}")
  }

  def getPermutation(n: Int, k: Int): String = {
    if (n < 0 || n > 9) return ""
    var result = ""
    Range(1, n + 1).permutations.drop(k - 1).next().mkString
  }
}
