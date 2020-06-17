package com.kishan.scala.leetcode.juneChallenges

import java.util
import java.util.PriorityQueue

import scala.collection.JavaConverters._

object CheapestFlightsWithinKStops {
  def main(args: Array[String]): Unit = {
    val n = 5 // Number of cities
    val edges = Array(Array(1, 2, 10), Array(2, 0, 7), Array(1, 3, 8), Array(4, 0, 10), Array(3, 4, 2), Array(4, 2, 10), Array(0, 3, 3), Array(3, 1, 6), Array(2, 4, 5))
    val src = 0
    val dst = 4
    val k = 1 // Number of Stops
    val result = findCheapestPrice(n, edges, src, dst, k)
    println(result, result == 5)

  }

  def findCheapestPrice(n: Int, flights: Array[Array[Int]], src: Int, dst: Int, K: Int): Int = {

    if (flights.length == 0) {
      return -1
    }
    //Building Graph
    var map: java.util.Map[Int, util.Map[Int, Int]] = new util.HashMap[Int, util.Map[Int, Int]]()
    flights.foreach(a => {
      if (map.get(a(0)) == null) {
        map.put(a(0), new util.HashMap[Int, Int]())
      }
      map.get(a(0)).put(a(1), a(2))
    })

    var q: PriorityQueue[Node] = new PriorityQueue[Node]((a, b) => a.cost - b.cost)
    q.add(Node(src, 0, -1))
    while (!q.isEmpty) {
      val curr: Node = q.poll
      if (curr.city == dst) return curr.cost
      if (curr.stop < K) {
        val nexts: util.Map[Int, Int] = map.getOrDefault(curr.city, new util.HashMap[Int, Int])
        for (next <- nexts.asScala) {
          q.add(Node(next._1, curr.cost + next._2, curr.stop + 1))
        }
      }
    }
    return -1
  }
}

case class Node(city: Int, cost: Int, stop: Int)