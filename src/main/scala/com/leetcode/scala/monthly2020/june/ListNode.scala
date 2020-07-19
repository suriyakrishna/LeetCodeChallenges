package com.leetcode.scala.monthly2020.june

//Definition for singly-linked list.
class ListNode(var _x: Int = 0, _next: ListNode = null) {
  var next: ListNode = _next
  var x: Int = _x

  override def toString: String = {
    var result = x.toString
    if (next != null) {
      result += s" -> ${next.toString}"
    }
    return result
  }
}

object ListNode {

  def ListToListNode(list: List[Int]): ListNode = {
    var root: ListNode = null
    val length = list.length
    if (length == 0 || list == null) return root
    for (i <- list.indices) {
      var node = ListNode(list(length - 1 - i), root)
      root = node
    }
    return root
  }

  def apply(_x: Int = 0, _next: ListNode = null): ListNode = new ListNode(_x, _next)
}
