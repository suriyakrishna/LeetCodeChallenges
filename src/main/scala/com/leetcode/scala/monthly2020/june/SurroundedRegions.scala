package com.leetcode.scala.monthly2020.june

import scala.collection.mutable

/*
* Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
  A region is captured by flipping all 'O's into 'X's in that surrounded region.
*
* */

/*
* Before:
* X X X X
  X O O X
  X X O X
  X O X X
*
* After:
* X X X X
  X X X X
  X X X X
  X O X X
*
* Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
* Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
* Two cells are connected if they are adjacent cells connected horizontally or vertically.
*  */

/*
* Approach: Breadth First Search or Depth First Search.
*
* 1. We have to go through the border of the board and check if we have any O's then we have to replace that O's with new character '*' also we have see if that 'O' has adjacent 'O' and we have to replace them with '*'.
* 2. After replacing all the O's in the border and their adjacent O's connected to the border. Once again we have to go through the each element of the array and we have replace the remaining O's with 'X' and '*' with 'O'.
*
* */


object SurroundedRegions {
  def main(args: Array[String]): Unit = {
    //    var board = Array(Array('x', 'x', 'x', 'x'), Array('x', 'o', 'o', 'x'), Array('x', 'x', 'o', 'x'), Array('x', 'o', 'x', 'x'))
    //    var board = Array(Array('o', 'x', 'x', 'o', 'x'), Array('x', 'o', 'o', 'x', 'o'), Array('x', 'o', 'x', 'o', 'x'), Array('o', 'x', 'o', 'o', 'o'), Array('x', 'x', 'o', 'x', 'o'))
    var board = Array(Array('x', 'o', 'x', 'o', 'x', 'o'), Array('o', 'x', 'o', 'x', 'o', 'x'), Array('x', 'o', 'x', 'o', 'x', 'o'), Array('o', 'x', 'o', 'x', 'o', 'x'))
    //        var board = Array(Array('x', 'o', 'x'), Array('x', 'o', 'x'), Array('x', 'o', 'x'))
    println("BEFORE")
    board.foreach(a => println(a.mkString))
    solve(board)
    println("AFTER")
    board.foreach(a => println(a.mkString))
  }

  def solve(board: Array[Array[Char]]): Unit = {
    if (board.length == 0 || board(0).length == 0) return
    val rowLength = board.length
    val columnLength = board(0).length
    for (i <- board.indices) {
      if (board(i)(0).toUpper == 'O') depthFirstSearch(i, 0, board)
      if (board(i)(columnLength - 1).toUpper == 'O') depthFirstSearch(i, columnLength - 1, board)
    }

    for (j <- board(0).indices) {
      if (board(0)(j).toUpper == 'O') depthFirstSearch(0, j, board)
      if (board(rowLength - 1)(j).toUpper == 'O') depthFirstSearch(rowLength - 1, j, board)
    }

    for (i <- board.indices) {
      for (j <- board(0).indices) {
        if (board(i)(j).toUpper == 'O') {
          board(i)(j) = 'X'
        } else if (board(i)(j) == '*') {
          board(i)(j) = 'O'
        }
      }
    }
  }

  def depthFirstSearch(i: Int, j: Int, board: Array[Array[Char]]): Unit = {
    if (i < 0 || i > board.length - 1 || j < 0 || j > board(i).length - 1) return
    if (board(i)(j).toUpper == 'O') board(i)(j) = '*'
    if (i > 0 && board(i - 1)(j).toUpper == 'O') depthFirstSearch(i - 1, j, board)
    if (i < board.length - 1 && board(i + 1)(j).toUpper == 'O') depthFirstSearch(i + 1, j, board)
    if (j > 0 && board(i)(j - 1).toUpper == 'O') depthFirstSearch(i, j - 1, board)
    if (j < board(0).length - 1 && board(i)(j + 1).toUpper == 'O') depthFirstSearch(i, j + 1, board)
  }


  def solveBFS(board: Array[Array[Char]]): Unit = {
    if (board.length == 0 || board(0).length == 0) return
    var queue: mutable.Queue[(Int, Int)] = mutable.Queue()
    for (i <- board.indices) {
      if (board(i)(0) == 'O') BFS(i, 0, board)
      if (board(i)(board(0).length - 1) == 'O') BFS(i, board(0).length - 1, board)
    }

    for (j <- board(0).indices) {
      if (board(0)(j) == 'O') BFS(0, j, board)
      if (board(board.length - 1)(j) == 'O') BFS(board.length - 1, j, board)
    }

    for (i <- board.indices) {
      for (j <- board(0).indices) {
        if (board(i)(j) == '*') board(i)(j) = 'O' else if (board(i)(j) == 'O') board(i)(j) = 'X'
      }
    }

    def BFS(i: Int, j: Int, array: Array[Array[Char]]): Unit = {
      if (i < 0 || i > array.length - 1 || j < 0 || j > array(0).length - 1) return
      if (array(i)(j) == 'O') queue.enqueue((i, j))
      while (queue.nonEmpty) {
        val position = queue.dequeue()
        array(position._1)(position._2) = '*'
        if (position._1 > 0 && array(position._1 - 1)(position._2) == 'O' && !queue.contains((position._1 - 1, position._2))) queue.enqueue((position._1 - 1, position._2))
        if (position._1 < array.length - 1 && array(position._1 + 1)(position._2) == 'O' && !queue.contains((position._1 + 1, position._2))) queue.enqueue((position._1 + 1, position._2))
        if (position._2 > 0 && array(position._1)(position._2 - 1) == 'O' && !queue.contains((position._1, position._2 - 1))) queue.enqueue((position._1, position._2 - 1))
        if (position._2 < array(0).length - 1 && array(position._1)(position._2 + 1) == 'O' && !queue.contains((position._1, position._2 + 1))) queue.enqueue((position._1, position._2 + 1))
      }
    }
  }
}
