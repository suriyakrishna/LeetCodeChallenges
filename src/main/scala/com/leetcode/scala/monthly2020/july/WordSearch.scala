package com.leetcode.scala.monthly2020.july

/*
* Given a 2D board and a word, find if the word exists in the grid.
* The word can be constructed from letters of sequentially adjacent cell,
* where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
*
* */

/*
* board =
  [
    ['A','B','C','E'],
    ['S','F','C','S'],
    ['A','D','E','E']
  ]

  Given word = "ABCCED", return true.
  Given word = "SEE", return true.
  Given word = "ABCB", return false.
*
*
* Constraints:

    board and word consists only of lowercase and uppercase English letters.
    1 <= board.length <= 200
    1 <= board[i].length <= 200
    1 <= word.length <= 10^3
*
* */

/*
* Approach: DFS - Depth First Search
*
* */

object WordSearch {
  def exist(board: Array[Array[Char]], word: String): Boolean = {
    val m = board.length
    val n = board(0).length
    var result = false
    for (i <- 0 until m) {
      for (j <- 0 until n) {
        if (dfs(board, word, i, j, 0)) {
          result = true
        }
      }
    }
    result
  }

  def dfs(board: Array[Array[Char]], word: String, i: Int, j: Int, k: Int): Boolean = {
    val m = board.length
    val n = board(0).length
    if (i < 0 || j < 0 || i >= m || j >= n) return false
    if (board(i)(j) == word.charAt(k)) {
      val temp = board(i)(j)
      board(i)(j) = '#'
      if (k == word.length - 1) return true
      else if (dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1)) return true
      board(i)(j) = temp
    }
    return false
  }

  def main(args: Array[String]): Unit = {

    // Whenever the dfs is executed the values of array is getting updated and 2nd, 3rd test is getting failed. So we created 3 different boards with the same values.
    val board: Array[Array[Char]] = Array(
      Array('A', 'B', 'C', 'E'),
      Array('S', 'F', 'C', 'S'),
      Array('A', 'D', 'E', 'E')
    )
    val board1 = Array(
      Array('A', 'B', 'C', 'E'),
      Array('S', 'F', 'C', 'S'),
      Array('A', 'D', 'E', 'E')
    )
    val board2 = Array(
      Array('A', 'B', 'C', 'E'),
      Array('S', 'F', 'C', 'S'),
      Array('A', 'D', 'E', 'E')
    )
    val word = "ABCCED"
    val word1 = "SEE"
    val word2 = "ABCB"

    val result = exist(board, word)
    val result1 = exist(board1, word1)
    val result2 = exist(board2, word2)

    println(s"Result: ${result}, ${result == true}")
    println(s"Result: ${result1}, ${result1 == true}")
    println(s"Result: ${result2}, ${result2 == false}")

  }
}
