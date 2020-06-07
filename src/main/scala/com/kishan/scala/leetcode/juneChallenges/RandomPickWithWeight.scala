package com.kishan.scala.leetcode.juneChallenges

import scala.util.Random


/*
* Given an array w of positive integers,
* where w[i] describes the weight of index i,
* write a function pickIndex which randomly picks an index in proportion to its weight.
*
*/

/*
* Input:
  ["Solution","pickIndex"]
  [[[1]],[]]
  Output: [null,0]
*
* Input:
  ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
  [[[1,3]],[],[],[],[],[]]
  Output: [null,0,1,1,1,0]
*/


/*
* Approach:
*
* 1. Calculation Running total for each element of the array.
* 2. Generating a Random number using scala.util.Random (Including upper boundary Value).
* 3. Using Binary Search Algorithm to search the range where the random number is located.
* 4. Finally returning the upper boundary value of the range. Which is the result.
*
*  */

/*
* If Input: [8, 9]
*
* Running sum will be [8, 17]
*
* If our Random number lies between 1-8 we will pick the first index.
* If our random number lies between 9-17 we will pick the second index
*
* We will ending up picking the index which has the highest probability
*
* */


class RandomPickWithWeight(_w: Array[Int]) {

  private val length = _w.length
  private val totalSum = _w.sum
  private val random = new Random()
  private var preSum: Array[Int] = _w.scan(0)((a, b) => a + b).drop(1)

  def pickIndex(): Int = {
    val randomNumber = random.nextInt(totalSum) + 1
    var head = 0
    var tail = preSum.length - 1
    var mid: Int = head + (tail - head) / 2
    while (head < tail) {
      mid = head + (tail - mid) / 2
      if (randomNumber > preSum(mid)) {
        head = mid + 1
      } else {
        tail = mid
      }
    }
    return if (preSum(tail) >= randomNumber) tail else head
  }


}