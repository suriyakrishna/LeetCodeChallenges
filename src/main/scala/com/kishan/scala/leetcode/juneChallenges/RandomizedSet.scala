package com.kishan.scala.leetcode.juneChallenges

import java.util

import scala.util.Random

/*
* Design a data structure that supports all following operations in average O(1) time.
    insert(val): Inserts an item val to the set if not already present.
    remove(val): Removes an item val from the set if present.
    getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
* */

/*
*
// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
* */

/*
* Approach:
*
* 1. Using Map Type we can achieve 0(1) for inserting, accessing and removing item.
* 2. For getting Random number we can create random object using Random and we can get the random integer number which will yield random integer number for the limit. We can use the random integer number to get item from the Map.
*
* First, we will create two map object -
*   a. valueMap object will hold the value as key and index as value.
*   b. indexMap object will hold the index as key and value as value.
*
* Insert Operation:
* When ever we want a value to be inserted into the valueMap. First we will check if valueMap contains that value. If it doesn't have the value we will insert the element into valueMap with the index as value and we will insert value to the indexMap with index as key.
*
* Remove Operation:
* 1. First, we will get the index of the value to be removed from the valueMap.
* 2. We will remove the index from the valueMap and value from indexMap.
* 3. Now we have to replace the index value that has been removed, with the last Index i.e If [0,1,2] are our Indices and we removed 1 so we will have [0,2]. Now, we have to replace 2 with 1. By doing so we will not have any discrepancy in the order of index values.
* 4. For that we will get the tail element from the indexMap.
* 5. We will replace the index of the tail element with the index of the value that we removed and we will create new entry for that index in the indexMap and we will remove the tailelem from the indexMap
*
* getRandom:
* 1. If the size of value map is 0 we will return -1. If size of value map is 1 we will return tail or head of values from the indexMap.
* 2. For other cases we have to get the random integer value for the length of valueMap.
* 3. We will use the randomInteger value to get the item from the indexMap.
* */


class RandomizedSet() {

  private val random = new Random()
  /** Initialize your data structure here. */
  private var valueMap: java.util.Map[Int, Int] = new util.HashMap[Int, Int]()
  private var indexMap: java.util.Map[Int, Int] = new util.HashMap[Int, Int]()

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  def insert(`val`: Int): Boolean = {
    if (valueMap.getOrDefault(`val`, Int.MinValue) != Int.MinValue) {
      false
    } else {
      valueMap.put(`val`, valueMap.size())
      indexMap.put(indexMap.size(), `val`)
      true
    }
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  def remove(`val`: Int): Boolean = {
    if (valueMap.getOrDefault(`val`, Int.MinValue) != Int.MinValue) {
      val index = valueMap.get(`val`)
      valueMap.remove(`val`)
      indexMap.remove(index)
      val tailElem = indexMap.getOrDefault(indexMap.size, Int.MinValue)
      if (tailElem != Int.MinValue) {
        indexMap.put(index, tailElem)
        valueMap.put(tailElem, index)
        indexMap.remove(indexMap.size()-1)
      }
      true
    } else {
      false
    }
  }

  /** Get a random element from the set. */
  def getRandom(): Int = {
    if (valueMap.size == 0) {
      return -1
    }

    if (valueMap.size == 1) {
      return indexMap.get(0)
    }
    val index: Int = random.nextInt(valueMap.size)

    indexMap.get(index)
  }
}
