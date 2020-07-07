package com.leetcode.scala.monthly2020.july

import scala.collection.mutable

/*
* There are 8 prison cells in a row, and each cell is either occupied or vacant.
* Each day, whether the cell is occupied or vacant changes according to the following rules:
  * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
  * Otherwise, it becomes vacant.
* (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
*
* We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
* Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
*
* */

/*
* Input: cells = [0,1,0,1,1,0,0,1], N = 7
  Output: [0,0,1,1,0,0,0,0]
  Explanation:
  The following table summarizes the state of the prison on each day:
  Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
  Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
  Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
  Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
  Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
  Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
  Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
  Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
*
* Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
  Output: [0,0,1,1,1,1,1,0]
*
* Note:
  * cells.length == 8
  * cells[i] is in {0, 1}
  * 1 <= N <= 10^9
*
* */


/*
* Approach: Memoization
*
* We can implement this program using brute force but when ever the input increase it will take too much time to compute the result.
* Inorder to overcome the above issue we need to store the result in the map and when ever we see the same key/cycle in the map
* we will get the n value for the key and we need to compute and modify the n.
*
*
* */

object PrisonCellsAfterNDays {
  def main(args: Array[String]): Unit = {
    val input = Array(1, 0, 0, 1, 0, 0, 1, 0)
    val n = 1000000000
    val result = prisonAfterNDays(input, n)
    println(s"Result: [${result.mkString(", ")}], ${result.mkString(",") == "0,0,1,1,1,1,1,0"}")
  }

  def prisonAfterNDays(cells: Array[Int], N: Int): Array[Int] = {
    var n: Int = N
    var map: mutable.HashMap[String, Int] = mutable.HashMap()
    var currDay: Array[Int] = Array(cells: _*)
    while (n > 0) {
      var modified: Array[Int] = Array(currDay: _*)
      map += (currDay.mkString -> n)
      for (i <- cells.indices) {
        if ((i == 0 || i == cells.length - 1) && currDay(i) != 0) {
          modified(i) = 0
        } else if (i >= 1 && i <= cells.length - 2) {
          val prev = currDay(i - 1)
          val next = currDay(i + 1)
          if (prev == next) {
            modified(i) = 1
          } else {
            modified(i) = 0
          }
        }
      }
      currDay = Array(modified: _*)
      n -= 1
      if (map.contains(currDay.mkString)) {
        n = n % (map(currDay.mkString) - n)
      }
    }
    return currDay
  }
}
