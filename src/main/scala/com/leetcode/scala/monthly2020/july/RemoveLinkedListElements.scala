package com.leetcode.scala.monthly2020.july

import com.leetcode.scala.monthly2020.june.ListNode

/*
* Remove all elements from a linked list of integers that have value val.
*
* */

/*
* Input:  1->2->6->3->4->5->6, val = 6
  Output: 1->2->3->4->5
*
* */


/*
* Approach - 1:
*
* 1. Iterate through linked list and get all the elements into a list which is not equal to `val`.
* 2. No build a linked list out of the list which created in the previous step.
* Time Complexity - O(n * n)
*
* Apporach - 2:
*
* Input: 1 -> 1 -> 2 -> 3 -> 1 -> 4 -> 1
* `val` : 1
* Output: 2 -> 3 -> 4
*
* 1. We have to change the head of the list if it matches with the `val`.
*    After our first while loop our node will become
*    2 -> 3 -> 1 -> 4 -> 1
* 2. We know after the first while loop we will not have 1 at the head of the list. We will create a temp node i and we will have the reference of the node in i.
* 3. We have to check if i is not null and i.next is not null in while loop.
* ---- Whenever we find the match we need to change the reference of the next else we need to move to next node.
*
* Iterations
* 1 ->  i : 2 -> 3 -> 1 -> 4 -> 1, i.next -> 3 -> 1 -> 4 -> 1 We don't have match so we need to change reference of i. i = 3 -> 1 -> 4 -> 1
* 2 ->  i : 3 -> 1 -> 4 -> 1, i.next -> 1 -> 4 -> 1
*   Here i.next.x == 1 so the reference of i.next = i.next.next i.e i = 3 -> 4 -> 1 => i.next = 4 -> 1
* 3 -> i: 3 -> 4 -> 1,  i.next = 4 -> 1
*   No match. i = 4 -> 1
* 4 -> i: 4 -> 1, i.next -> 1
*   Here i.next.x == 1 so the reference of i.next = i.next.next. i.e. i = 4 and i.next = null
*
* 4. Since the i.next is null loop will exit and we will return the node.
*
*  */


object RemoveLinkedListElements {
  //ApproachOne - Time Complexity: O(n * n)
  def removeElementsTC(head: ListNode, `val`: Int): ListNode = {
    var root = head
    var resultList: List[Int] = List()
    while (root != null) {
      if (root.x != `val`) {
        resultList = resultList :+ root.x
      }
      root = root.next
    }
    ListNode.ListToListNode(resultList)
  }

  def main(args: Array[String]): Unit = {
    val LinkedList = ListNode.ListToListNode(Range(1, 11).toList)
    val result = removeElements(LinkedList, 5)
    println(s"Before Removing Element: ${LinkedList}")
    println(s"After Removing Element: ${result}")
    val LinkedList1 = ListNode.ListToListNode(List(4, 2, 3, 4, 4, 4, 3, 4))
    println(s"Before Removing Element: ${LinkedList1}")
    val result1 = removeElements(LinkedList1, 4)
    println(s"After Removing Element: ${result1}")
  }

  //Best Approach - Time Complexity: O(n)
  def removeElements(head: ListNode, `val`: Int): ListNode = {
    var node = head
    while (node != null && node.x == `val`) node = node.next //to remove the matching items from the head of the list
    var i = node
    while (i != null && i.next != null) {
      if (i.next.x == `val`) {
        i.next = i.next.next
      } else {
        i = i.next
      }
    }
    return node
  }


}
