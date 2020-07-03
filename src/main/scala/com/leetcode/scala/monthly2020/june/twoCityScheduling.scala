package com.leetcode.scala.monthly2020.june

/*
There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0],
and the cost of flying the i-th person to city B is costs[i][1].
Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
*/

/*
Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation:
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

Note:
  1.  1 <= costs.length <= 100
  2.  It is guaranteed that costs.length is even.
  3.  1 <= costs[i][0], costs[i][1] <= 1000
*/
  
/*
* Approach (Greedy Algorithm)
* 1. Find absolute difference.
* 2. Sort in descending order.
* 3. Iterate and get the minimum of the city. Update the sum.
* 4. Have the count of the cityA and cityB.
* */


object twoCityScheduling {
  def main(args: Array[String]): Unit = {
    val costs = Array(Array(259, 770), Array(448, 54), Array(926, 667), Array(184, 139), Array(840, 118), Array(577, 469))
    //    val costs1 = Array(Array(10, 20), Array(30, 200), Array(400, 50), Array(30, 20))
    val result = twoCitySchedCost(costs)
    println(result, result == 1859)
  }

  def twoCitySchedCost(costs: Array[Array[Int]]): Int = {
    val length = costs.length
    if (length % 2 != 0 && (length <= 1 && length >= 100)) {
      return -1
    }
    val costsSorted: Array[Array[Int]] = costs.map(a => (a, math.abs(a(0) - a(1)))).sortBy(a => a._2)(Ordering.Int.reverse).map(_._1)
    var cityA: Int = 0
    var cityB: Int = 0
    var sum: Int = 0
    for (person <- costsSorted) {
      val a = person(0)
      val b = person(1)
      if (a < b) {
        if (cityA < length / 2) {
          sum += a
          cityA += 1
        } else {
          sum += b
          cityB += 1
        }
      } else {
        if (cityB < length / 2) {
          sum += b
          cityB += 1
        } else {
          sum += a
          cityA += 1
        }
      }
    }
    sum
  }


}
