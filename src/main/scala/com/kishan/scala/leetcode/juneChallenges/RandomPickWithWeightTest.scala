package com.kishan.scala.leetcode.juneChallenges

object RandomPickWithWeightTest {
  def main(args: Array[String]): Unit = {
    val input: Array[String] = Array("Solution", "pickIndex")
    val inputInt: Array[Int] = input.map(_.length)
    val r = new RandomPickWithWeight(inputInt)
    println(r.pickIndex())
  }
}
