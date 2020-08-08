package com.leetcode.scala.monthly2020.august

import scala.collection.mutable

/*
* Design a data structure that supports the following two operations:
* void addWord(word)
* bool search(word)
* search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
*
* */

/*
* addWord("bad")
  addWord("dad")
  addWord("mad")
  search("pad") -> false
  search("bad") -> true
  search(".ad") -> true
  search("b..") -> true
*
* Note:
  You may assume that all words are consist of lowercase letters a-z.
*
* */

/*
* Best Approach will be Trie Data Structure.
*
* Here, The word with same length will be stored in the HashSet and mapped to it's length in the HashMap.
*
* To check if we have the word in dictionary.
* 1. First, we will check if the length is available in the dictionary. If not we will return false.
* 2. If we have the length, we will get all the words for that length and then we have to iterate through each word.
* 3. For each word, we have to count the number of matching elements, it the number of matching and length of the word is equal we will return true.
* 4. If we don't find any match we will return false.
*
* */


class WordDictionary() {

  /** Initialize your data structure here. */
  private var dictionary: mutable.HashMap[Int, mutable.HashSet[String]] = mutable.HashMap()


  /** Adds a word into the data structure. */
  def addWord(word: String): Unit = {
    val len = word.length
    if (!dictionary.contains(len)) {
      dictionary += (len -> mutable.HashSet(word))
    } else {
      dictionary(len).add(word)
    }
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  def search(word: String): Boolean = {
    val len = word.length
    if (!dictionary.contains(len)) return false
    val words = dictionary(len)
    words.foreach(a => {
      var i = 0
      while (i < a.length && (word(i) == '.' || a.charAt(i) == word.charAt(i))) {
        i += 1
      }
      if (i == len) return true
    })
    return false
  }
}


object AddandSearchWord {
  def main(args: Array[String]): Unit = {
    val wordDictionary = new WordDictionary()
    wordDictionary.addWord("bad")
    wordDictionary.addWord("dad")
    wordDictionary.addWord("mad")
    wordDictionary.search("pad") // false
    wordDictionary.search("bad") // true
    wordDictionary.search(".ad") // true
    wordDictionary.search("b..") // true
  }
}
