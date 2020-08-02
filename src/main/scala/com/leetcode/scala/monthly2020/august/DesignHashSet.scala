package com.leetcode.scala.monthly2020.august

/*
* Design a HashSet without using any built-in hash table libraries.
* To be specific, your design should include these functions:
  * add(value): Insert a value into the HashSet.
  * contains(value) : Return whether the value exists in the HashSet or not.
  * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
* */

/*
* MyHashSet hashSet = new MyHashSet();
  hashSet.add(1);
  hashSet.add(2);
  hashSet.contains(1);    // returns true
  hashSet.contains(3);    // returns false (not found)
  hashSet.add(2);
  hashSet.contains(2);    // returns true
  hashSet.remove(2);
  hashSet.contains(2);    // returns false (already removed)
*
* Note:
  * All values will be in the range of [0, 1000000].
  * The number of operations will be in the range of [1, 10000].
  * Please do not use the built-in HashSet library.
*
* */

/*
* Approach: Using Big Array
* 1. Since we know the range we can build array of boolean with the range and key will be the index of the array.
* 2. But lot of space will be wasted.
* */

class MyHashSet() {

  /** Initialize your data structure here. */
  private var array: Array[Boolean] = Array.fill(1000001)(false)

  def add(key: Int): Unit = {
    array(key) = true
  }

  def remove(key: Int): Unit = {
    if (array(key)) {
      array(key) = false
    }
  }

  /** Returns true if this set contains the specified element */
  def contains(key: Int): Boolean = {
    return array(key)
  }

}

object DesignHashSet {

  def main(args: Array[String]): Unit = {
    val hashSet: MyHashSet = new MyHashSet()
    hashSet.add(1)
    hashSet.add(2)
    hashSet.contains(1) // returns true
    hashSet.contains(3) // returns false (not found)
    hashSet.add(2)
    hashSet.contains(2) // returns true
    hashSet.remove(2)
    hashSet.contains(2) // returns false (already removed)
  }

}
