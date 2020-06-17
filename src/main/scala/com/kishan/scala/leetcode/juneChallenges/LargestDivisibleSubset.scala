package com.kishan.scala.leetcode.juneChallenges


/*
* Given a set of distinct positive integers, find the largest subset such that
* every pair (Si, Sj) of elements in this subset satisfies:
* Si % Sj = 0 or Sj % Si = 0.
* If there are multiple solutions, return any subset is fine.
*
* */

/*
* Input: [1,2,3]
  Output: [1,2] (of course, [1,3] will also be ok)
* Input: [1,2,4,8]
  Output: [1,2,4,8]
* */

/*
* Approach:
*
* We will check if the array is empty or it has only one element. If yes we will return the array as list.
*
* If array length is greater than 1.
* 1. First, we will sort the elements in the array. [3,4,16,8] -> [3,4,8,16]
* 2. We will create a empty Map for which the integer value will be the key and the possible integers will be stored as the list of integers.
* 3. So for every Integer in the list it should need to have the self value in the temp_list of value. Because, the integer will be divisible by itself.
* 4. We will iterate through the each element of the list and if we have any keys in the map we will try to divide the number by the key.
*    If the number is divisible and if we have list of integer for the key we will assign this list to temp_list that we created.
* 5. Next, we will add the current number to the temp list and we will put the (key, temp_list) to the map.
* 6. Finally, we will get the values from the map and will return the list with maximum length.
*
* Explanation:
* input = [3,4,16,8]
*
* Step 1: Sorting -> [3,4,8,16]
* Step 2: Create empty Map[Int, List[Int]]
* Step 3: Iterate through the the sorted list
* Step 4: For every int in the list. We will have a key -> value in the Map.
*
* Iteration:
* 3 -> [3]
* 4 % 3 is not equal to 0. temp_list = [] and 4 is divisible by 4. So 4 -> [4]
* 8 % 3 no, 8%4 equal to 0. temp_list = [4] and 8 will be divisible by it self. So 8 -> [4,8]
* 16 % 3 no, 16 % 4. temp_list = [4] and 16 % 8. temp_list = [4,8] and 16 will be divisible by itself. So 16 -> [4,8,16]
*
* we will get values from the map. [[3], [4], [4,8], [4,8,16]] and we will return the list with maximum length.
* */


object LargestDivisibleSubset {
  def main(args: Array[String]): Unit = {
    val nums = Array(3, 4, 16, 8)

    println(largestDivisibleSubset(nums).mkString(","))
  }

  def largestDivisibleSubset(nums: Array[Int]): List[Int] = {
    if (nums.length <= 1) {
      return nums.toList
    }
    val sortedNums = nums.sortBy(a => a)
    var map: Map[Int, List[Int]] = Map()
    for (num <- sortedNums) {
      var list: List[Int] = List()
      for (key <- map.keys) {
        if (num % key == 0) {
          if (map(key).length > list.length) {
            list = map(key)
          }
        }
      }
      list = list :+ num
      map += (num -> list)
    }
    return map.values.maxBy(_.length)
  }

}
