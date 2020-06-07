package com.kishan.scala.leetcode.juneChallenges


/*
* You are given coins of different denominations and a total amount of money.
* Write a function to compute the number of combinations that make up that amount.
* You may assume that you have infinite number of each kind of coin.
*/


/*
* Input: amount = 5, coins = [1, 2, 5]
  Output: 4
  Explanation: there are four ways to make up the amount:
  5=5
  5=2+2+1
  5=2+1+1+1
  5=1+1+1+1+1
* */

/*
* Approach: Dynamic Programming
*
* Assume above inputs. Creating Empty MultiDimensional Array filled with 0(Space complexity -> 0(n+1*m+1))
* n -> Length coins array
* m -> value of the amount
*
* 0,1,2,3,4,5
* [
* 0       -> [1, 0, 0, 0, 0, 0]
* 1       -> [1, 1, 1, 1, 1, 1]
* [1,2]   -> [1, 1, 1+1, 1+1, 1+2, 1+2]
* [1,2,5] -> [1, 1, 2, 2, 3, 3+1]
* ]
*
* In order to get the probability we have use the below formula
* element[i][j] = element[i-1][j]
* when we have difference of j and coin is greater than 0 we have to get the value from the same row for the corresponding index and we have to add it to current index
* element[i][j] = element[i-1][j] + element[i][j-coin]
*/


object CoinChange2 {
  def main(args: Array[String]): Unit = {
    val amount = 5
    val coins = Array(1, 2, 5)
    val result = changeSingleDimesionArray(amount, coins)
    println(result, result == 4)
  }

  // Memory Efficient
  def changeSingleDimesionArray(amount: Int, coins: Array[Int]): Int = {
    val length = coins.length
    var dp: Array[Int] = Array.ofDim[Int](amount + 1)
    dp(0) = 1
    for (i <- 1 until length + 1) {
      for (j <- 1 until amount + 1) {
        if (j - coins(i - 1) >= 0) {
          dp(j) += dp(j - coins(i - 1))
        }
      }
    }
    return dp(amount)
  }

  // Multi dimesional Array
  def change(amount: Int, coins: Array[Int]): Int = {
    val length = coins.length
    var dp: Array[Array[Int]] = Array.ofDim[Int](length + 1, amount + 1)
    dp.foreach(a => a(0) = 1)
    for (i <- 1 until length + 1) {
      for (j <- 1 until amount + 1) {
        dp(i)(j) = dp(i - 1)(j)
        if (j - coins(i - 1) >= 0) {
          dp(i)(j) += dp(i)(j - coins(i - 1))
        }
      }
    }
    return dp(length)(amount)
  }
}
