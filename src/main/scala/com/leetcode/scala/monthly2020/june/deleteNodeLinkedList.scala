package com.leetcode.scala.monthly2020.june

//Delete Node in a Linked List

/*
* Input: head = [4,5,1,9], node = 5
* Output: [4,1,9]
* Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.
*/

/*
* Input: head = [4,5,1,9], node = 1
* Output: [4,5,9]
* Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
*/

object deleteNodeLinkedList {
  def main(args: Array[String]): Unit = {

    //Constructing Linked List
    var linkedList3 = new ListNode(9)
    var linkedList2 = new ListNode(1)
    linkedList2.next = linkedList3
    var linkedList1 = new ListNode(5)
    linkedList1.next = linkedList2
    var head = new ListNode(4)
    head.next = linkedList1


    println("Items Before Deleting The Node")
    printItemInLinkedList(head)

    println("\nItems After Deleting The Node")
    deleteNode(linkedList1)
    printItemInLinkedList(head)

  }

  def deleteNode(node: ListNode): Unit = {
    node.x = node.next.x
    node.next = node.next.next
  }

  def printItemInLinkedList(LinkedList: ListNode): Unit = {
    var ll: ListNode = LinkedList
    while (ll != null) {
      println(ll.x)
      ll = ll.next
    }
  }
}
