package com.leetcode.scala.monthly2020.august

import scala.collection.mutable

/*
* In a given grid, each cell can have one of three values:

    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.
*
* Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
* Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
*
* */

/*
* Input: [[2,1,1],[1,1,0],[0,1,1]]
  Output: 4
*
* Input: [[2,1,1],[0,1,1],[1,0,1]]
  Output: -1
  Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
*
* Input: [[0,2]]
  Output: 0
  Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
*
*
* Note:
  1. 1 <= grid.length <= 10
  2. 1 <= grid[0].length <= 10
  3. grid[i][j] is only 0, 1, or 2.
*
* */

/*
* Approach: BFS - Breadth First Search
*
* Detailed explanation in comments.
*
* */

object RottingOranges {

  def main(args: Array[String]): Unit = {
    var grid = Array(Array(2, 1, 1), Array(1, 1, 0), Array(0, 1, 1))
    var grid1 = Array(Array(2, 1, 1), Array(0, 1, 1), Array(1, 0, 1))
    var grid2 = Array(Array(0, 2))
    var grid3 = Array(Array(1, 2, 1, 1, 2, 1, 1))
    val testCases = Array(grid, grid1, grid2, grid3)
    val expectedResult = Array(4, -1, 0, 2)
    val actualResult = testCases.map(orangesRotting)
    println(s"Results: ${actualResult.mkString(" ")}, ${actualResult.sameElements(expectedResult)}")

  }

  def orangesRotting(grid: Array[Array[Int]]): Int = {
    if (grid.isEmpty) return 0

    // Declaring queue and visited for BFS
    var queue: mutable.Queue[mutable.Queue[(Int, Int)]] = mutable.Queue()
    var visited: mutable.HashSet[(Int, Int)] = mutable.HashSet()

    // Declaring counter to count time and fresh oranges
    var time = 0
    var freshOranges = 0

    var initialRottenOranges: mutable.Queue[(Int, Int)] = mutable.Queue()

    /* 1. Find all the rotten oranges in the grid and add it to the initialRottenOranges queue
    *  2. Also, count all the fresh oranges.
    * */
    for (i <- grid.indices) {
      for (j <- grid(i).indices) {
        if (grid(i)(j) == 2) {
          initialRottenOranges.enqueue((i, j))
        }
        if (grid(i)(j) == 1) freshOranges += 1
      }
    }

    // To start with BFS - Add the initialRottenOranges to bfs queue
    queue.enqueue(initialRottenOranges)

    while (queue.nonEmpty) {
      var currentRotten = queue.dequeue()
      var newRottens: mutable.Queue[(Int, Int)] = mutable.Queue()

      /* For each queue of rotten oranges we need to find all their adjacent and we need to add it to newRottens
      *  We need to increment the the time by if we have newRottens.nonEmpty
      *  We need to decrement the freshOranges by 1 if a orange gets rotten
      * */
      while (currentRotten.nonEmpty) {
        val position = currentRotten.dequeue
        val i = position._1
        val j = position._2
        if (!visited.contains(position)) {
          visited.add(position)
          if (i > 0 && grid(i - 1)(j) == 1) {
            grid(i - 1)(j) = 2
            newRottens.enqueue((i - 1, j))
            freshOranges -= 1
          }
          if (i < grid.length - 1 && grid(i + 1)(j) == 1) {
            grid(i + 1)(j) = 2
            newRottens.enqueue((i + 1, j))
            freshOranges -= 1
          }
          if (j > 0 && grid(i)(j - 1) == 1) {
            grid(i)(j - 1) = 2
            newRottens.enqueue((i, j - 1))
            freshOranges -= 1
          }
          if (j < grid(0).length - 1 && grid(i)(j + 1) == 1) {
            grid(i)(j + 1) = 2
            newRottens.enqueue((i, j + 1))
            freshOranges -= 1
          }
        }
      }
      if (newRottens.nonEmpty) {
        time += 1
        queue.enqueue(newRottens)
      }
    }

    //We will check if all the freshOranges got rotten. If not we will return -1
    if (freshOranges > 0) return -1
    return time
  }
}
