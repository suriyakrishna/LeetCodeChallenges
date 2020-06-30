package com.kishan.scala.leetcode.juneChallenges

import java.util

import scala.collection.JavaConverters._
import scala.collection.mutable

/*
* Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
* All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
*
* Note:
  1. If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
     For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
  2. All airports are represented by three capital letters (IATA code).
  3. You may assume all tickets form at least one valid itinerary.
  4. One must use all the tickets once and only once.
*
* */

/*
* Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
  Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
*
*
* Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
  Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
  Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
*
*  */

/*
* Approach: DFS - Depth First Search
*
* 1. We have to build HashMap with Source as Key and Queue of Destination - By Implementing Priority Queue as value.
* 2. We have to Start from JFK and find the city which doesn't have any more destination and add to linked list at head position.
* 3. We have to recursively go through each Priority Queue and have to add each destination at the head of Linked List
* 4. Finally convert LinkedList asScala List and return the result.
*
* */

object ReconstructItinerary {
  private var map: mutable.HashMap[String, mutable.PriorityQueue[String]] = mutable.HashMap()
  private var result: util.LinkedList[String] = new util.LinkedList()

  def findItinerary(tickets: List[List[String]]): List[String] = {
    tickets.foreach(a => {
      if (!map.contains(a.head)) {
        var pq: mutable.PriorityQueue[String] = mutable.PriorityQueue.empty[String](Ordering.String.reverse)
        map += (a.head -> pq)
      }
      map(a.head).enqueue(a.last)
    })

    dfs("JFK")
    return result.asScala.toList
  }

  def dfs(startCity: String): Unit = {
    var arrivals = map.getOrElse(startCity, null)
    while (arrivals != null && arrivals.nonEmpty) {
      dfs(arrivals.dequeue())
    }
    result.add(0, startCity)
  }

  def main(args: Array[String]): Unit = {
    val input1: List[List[String]] = List(List("MUC", "LHR"), List("JFK", "MUC"), List("SFO", "SJC"), List("LHR", "SFO"))
    val input2: List[List[String]] = List(List("JFK", "SFO"), List("JFK", "ATL"), List("SFO", "ATL"), List("ATL", "JFK"), List("ATL", "SFO"))
    val input3: List[List[String]] = List(List("JFK", "KUL"), List("JFK", "NRT"), List("NRT", "JFK"))
    val input4: List[List[String]] = List(List("EZE", "AXA"), List("TIA", "ANU"), List("ANU", "JFK"), List("JFK", "ANU"), List("ANU", "EZE"), List("TIA", "ANU"), List("AXA", "TIA"), List("TIA", "JFK"), List("ANU", "TIA"), List("JFK", "TIA"))
    val input5: List[List[String]] = List(List("EZE", "TIA"), List("EZE", "HBA"), List("AXA", "TIA"), List("JFK", "AXA"), List("ANU", "JFK"), List("ADL", "ANU"), List("TIA", "AUA"), List("ANU", "AUA"), List("ADL", "EZE"), List("ADL", "EZE"), List("EZE", "ADL"), List("AXA", "EZE"), List("AUA", "AXA"), List("JFK", "AXA"), List("AXA", "AUA"), List("AUA", "ADL"), List("ANU", "EZE"), List("TIA", "ADL"), List("EZE", "ANU"), List("AUA", "ANU"))
    val result = findItinerary(input5)
    println(s"Result: ${result.mkString(",")}, ${result.mkString(",") == "JFK,AXA,AUA,ADL,ANU,AUA,ANU,EZE,ADL,EZE,ANU,JFK,AXA,EZE,TIA,AUA,AXA,TIA,ADL,EZE,HBA"}")
  }

  //    ["JFK","ANU","EZE","AXA","TIA","ANU","JFK","TIA","ANU","TIA","JFK"]
  //    ["JFK","AXA","AUA","ADL","ANU","AUA","ANU","EZE","ADL","EZE","ANU","JFK","AXA","EZE","TIA","AUA","AXA","TIA","ADL","EZE","HBA"]


}
