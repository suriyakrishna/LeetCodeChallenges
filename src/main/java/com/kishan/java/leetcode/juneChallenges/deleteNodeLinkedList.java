package com.kishan.java.leetcode.juneChallenges;

public class deleteNodeLinkedList {

    public static void printItemsInLinkedList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode linkedList3 = new ListNode(9);
        ListNode linkedList2 = new ListNode(1);
        linkedList2.next = linkedList3;
        ListNode linkedList1 = new ListNode(5);
        linkedList1.next = linkedList2;
        ListNode head = new ListNode(4);
        head.next = linkedList1;

        System.out.println("Before Deleting the node");
        printItemsInLinkedList(head);

        deleteNode(linkedList2);
        System.out.println("\nAfter Deleting the node");
        printItemsInLinkedList(head);


    }
}
