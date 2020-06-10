package com.kishan.scala.leetcode.juneChallenges

import scala.util.matching.Regex

/*
* Given a string s and a string t, check if s is subsequence of t.
* A subsequence of a string is a new string which is formed from the original string by
* deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
* (ie, "ace" is a subsequence of "abcde" while "aec" is not).
*
* */

/*
* Input: s = "abc", t = "ahbgdc"
  Output: true
* Input: s = "axc", t = "ahbgdc"
  Output: false
* */

/*
* Approach:
*
* Regex:
* 1. Build Regex Pattern.
* 2. Check if we have matching string. If nonEmpty true. Else False
* */


object IsSubsequence {

  def isSubsequence(s: String, t: String): Boolean = {
    val regex = new Regex(s.map(a => s".*${a}").mkString)
    regex.findPrefixOf(t).nonEmpty
  }

  def main(args: Array[String]): Unit = {
    val s = "rjufvjafbxnbgriwgokdgqdqewn"
    val t = "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq"
    println(isSubsequence(s,t))
  }
}
