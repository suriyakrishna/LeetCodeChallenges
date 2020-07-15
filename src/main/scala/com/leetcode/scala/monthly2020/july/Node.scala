package com.leetcode.scala.monthly2020.july

/*
* Double Linked List Node - With child node
*
*  */


class Node(var _value: Int) {
  var value: Int = _value
  var prev: Node = null
  var next: Node = null
  var child: Node = null

  override def toString: String = {
    var result = value.toString
    if (next != null) {
      if (child != null) {
        result += s" -> Child(${child.toString})"
      }
      result += s" <-> ${next.toString}"
    }
    result
  }
}