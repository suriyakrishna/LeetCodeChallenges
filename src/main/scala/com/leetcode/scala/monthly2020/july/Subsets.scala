package com.leetcode.scala.monthly2020.july

/*
* Given a set of distinct integers, nums, return all possible subsets (the power set).
* Note: The solution set must not contain duplicate subsets.
*
* */

/*
* Input: nums = [1,2,3]
  Output:
  [
    [3],
    [1],
    [2],
    [1,2,3],
    [1,3],
    [2,3],
    [1,2],
    []
  ]
*
* */

/*
* Approach: Depth First Search
*
* [1,2,3]
*
*                 []
*                 |
*      -------------------
*     /            \      \
*   [1]           [2]     [3]
*   /  \         /
* [1,2] [1,3]  [2,3]
*   /
* [1,2,3]
*
*
* */

object Subsets {
  def main(args: Array[String]): Unit = {
    val nums = Array(1, 2, 3, 4)
    println(subsets(nums))
  }

  def subsets(nums: Array[Int]): List[List[Int]] = {
    var result: List[List[Int]] = List()
    if (nums == null) return result

    def dfs(array: Array[Int], subset1: List[Int] = List(), index: Int = 0): Unit = {
      var temp = subset1
      result = result :+ temp
      for (i <- index until array.length) {
        temp = temp :+ array(i)
        dfs(array, temp, i + 1)
        temp = temp.slice(0, temp.size - 1)
      }
    }

    dfs(nums)
    return result
  }
}
