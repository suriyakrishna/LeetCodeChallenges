package com.kishan.scala.leetcode.juneChallenges

/*
* Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
*
* */

/*
* Input: 3
  Output: 5
  Explanation:
  Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*
* */

/*
* Apporach: Dynamic Programming
*
* */
object UniqueBST {
  def main(args: Array[String]): Unit = {
    val result = numTrees(3)
    println(s"Result: ${result}, ${result == 5}")
  }

  def numTrees(n: Int): Int = {
    var countUniqueTrees = new Array[Int](n + 1)
    countUniqueTrees(0) = 1
    countUniqueTrees(1) = 1
    for (i <- 2 to n) {
      for (j <- 1 to i) {
        countUniqueTrees(i) = countUniqueTrees(i) + (countUniqueTrees(i - j) * countUniqueTrees(j - 1))
      }
    }
    return countUniqueTrees(n)
  }
}
