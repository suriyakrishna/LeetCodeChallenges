package com.leetcode.scala.monthly2020.july

import scala.collection.mutable

/*
* You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
* Grid cells are connected horizontally/vertically (not diagonally).
* The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
* The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
* One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
* Determine the perimeter of the island.
*
* */

/*
* Input:
  [[0,1,0,0],
  [1,1,1,0],
  [0,1,0,0],
  [1,1,0,0]]

  Output: 16
  Explanation: The perimeter is the 16 yellow stripes in the image below:
  * @Link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3383/
*
* */

/*
* Approach: Breadth First Search (BFS)
* 1. We have defined a case class to store the indexes as pair.
* 2. getIslandStart will find the edge of the island will give the Pair - from which we have to start the BFS.
* 3. getValue will return the value of the Pair.
* 4. In Our function islandPerimeter:
  * a. First, we will check if the grid is empty. If empty we will return 0.
  * b. If grid non-empty we will use getIslandStart to get the Pair from which we need to start.
  * c. We will build Queue(To store the nodes to be visited) and HashSet(To store the visited nodes).
  * d. We will enqueue the queue with start Pair and we will add the start Pair to the HashSet.
  * e. We will dequeue the queue and we will check for the conditions if the node is at the edge of the grid we will add (1 * no_of_edges shared with the edge of the grid) to the perimeter based on the fact that how many edges are at the edge of the grid for that particular node.
  * f. We will check if the node share it's edges with any nodes in top, left, right or bottom. If the node shares it's edge with any of the adjacent node and the value of the adjacent node is 1 and the node is not visited then we will enqueue the adjacent node to the queue and we will add the adjacent node to the HashSet.
  * g. If the above condition doesn't match then the adjacent node should be 0. So, we will add 1 to the perimeter.
  * h. Finally, the queue will be empty and we will be return the perimeter value.
  *
* */

case class Pair(x: Int, y: Int)

object IslandPerimeter {

  def main(args: Array[String]): Unit = {
    val grid = Array(Array(0, 1, 0, 0),
      Array(1, 1, 1, 0),
      Array(0, 1, 0, 0),
      Array(1, 1, 0, 0))

    val result = islandPerimeter(grid)

    println(s"Result: ${result}, ${result == 16}")

    val grid1 = Array(Array(1))

    val result1 = islandPerimeter(grid1)

    println(s"Result: ${result1}, ${result1 == 4}")

    val grid2 = Array(Array(1, 1), Array(1, 1))

    val result2 = islandPerimeter(grid2)

    println(s"Result: ${result2}, ${result2 == 8}")

  }

  def islandPerimeter(grid: Array[Array[Int]]): Int = {
    if (grid.isEmpty) return 0
    val start = getIslandStart(grid)
    var visited: mutable.HashSet[Pair] = mutable.HashSet()
    var queue: mutable.Queue[Pair] = mutable.Queue[Pair]()
    queue.enqueue(start)
    visited.add(start)
    var perimeter = 0
    while (queue.nonEmpty) {
      val currentPair = queue.dequeue()
      val i = currentPair.x
      var j = currentPair.y
      val left = Pair(i, j - 1)
      val right = Pair(i, j + 1)
      val top = Pair(i - 1, j)
      val down = Pair(i + 1, j)
      if (i == 0) perimeter += 1
      if (j == 0) perimeter += 1
      if (i == grid.length - 1) perimeter += 1
      if (j == grid(i).length - 1) perimeter += 1
      if (j > 0 && !visited.contains(left) && getValue(left, grid) == 1) {
        queue.enqueue(left)
        visited.add(left)
      } else if (j > 0 && !visited.contains(left) && getValue(left, grid) == 0) {
        perimeter += 1
      }
      if (j < grid(i).length - 1 && !visited.contains(right)) {
        if (getValue(right, grid) == 1) {
          queue.enqueue(right)
          visited.add(right)
        } else {
          perimeter += 1
        }
      }
      if (i > 0 && !visited.contains(top)) {
        if (getValue(top, grid) == 1) {
          queue.enqueue(top)
          visited.add(top)
        } else {
          perimeter += 1
        }
      }
      if (i < grid.length - 1 && !visited.contains(down)) {
        if (getValue(down, grid) == 1) {
          queue.enqueue(down)
          visited.add(down)
        } else {
          perimeter += 1
        }
      }
    }
    return perimeter
  }

  def getValue(pair: Pair, grid: Array[Array[Int]]): Int = {
    return grid(pair.x)(pair.y)
  }

  def getIslandStart(grid: Array[Array[Int]]): Pair = {
    var pair = Pair(0, 0)
    for (i <- grid.indices) {
      for (j <- grid(i).indices) {
        if (grid(i)(j) == 1) return Pair(i, j)
      }
    }
    return pair
  }

}
