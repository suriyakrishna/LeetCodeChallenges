package com.leetcode.scala.monthly2020.july

import scala.collection.mutable

/*
* There are a total of n courses you have to take, labeled from 0 to n-1.
* Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
* Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
* There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
*
* */

/*
* Input: 2, [[1,0]]
  Output: [0,1]
  Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .
*
* Input: 4, [[1,0],[2,0],[3,1],[3,2]]
  Output: [0,1,2,3] or [0,2,1,3]
  Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
             courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
             So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
*
* Note:
* 1. The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
* 2. You may assume that there are no duplicate edges in the input prerequisites.
*
* */

/*
* Approach: BFS/DFS
*
* 1. Create an array [coursePrerequisites] and keep track of count for each course. Index of array will denote the course.
* 2. Instantiate an empty array [result] and queue.
* 3. Iterate through coursePrerequisites and add the course into the queue and result array when coursePrerequisite for the course is '0'.
* 4. Now we have to iterate through the queue until queue becomes empty.
*   i.  dequeue and get the head of queue in the currentCourse variable.
*   ii. Then, we have to iterate through the preRequisites indices and we have to check if the start course of the current edge = currentCourse. If yes, then we have the decrement the end course (i.e first index of the edge) of the current edge by 1 and
*     at the same time we have to check if the coursePrerequisite for the end course is '0' if yes then we have to add the endCourse of the current edge to the result and we have to add the endCourse to the queue.
* 5. Finally, we have to check if the length of result is equal to numCourse. If yes, we will return result else return empty Array().
*
* */


object CourseScheduleII {
  def main(args: Array[String]): Unit = {

    val nums: Array[Array[Int]] = Array(Array(1, 0), Array(2, 0), Array(3, 1), Array(3, 2))
    findOrder(4, nums)
  }

  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
    //If the preRequisites are empty all the course which we need to complete will be independent course. So we need to return range of array from 0 until numCourses.[0,numCourses)
    if (prerequisites.isEmpty) return Range(0, numCourses).toArray

    //Count Prerequisites for each course
    var coursePrerequisites = Array.ofDim[Int](numCourses)
    for (i <- prerequisites.indices) {
      coursePrerequisites(prerequisites(i)(0)) += 1
    }

    //Add Courses without prerequisites to result and queue
    var result: Array[Int] = Array()
    var queue: mutable.Queue[Int] = mutable.Queue()
    coursePrerequisites.indices.foreach(i => {
      if (coursePrerequisites(i) == 0) {
        queue.enqueue(i)
        result = result :+ i
      }
    })

    //Check all the possible course in the prerequisites
    while (queue.nonEmpty) {
      val currentCourse = queue.dequeue()
      prerequisites.indices.foreach(i => {
        if (prerequisites(i)(1) == currentCourse) {
          coursePrerequisites(prerequisites(i)(0)) -= 1
          if (coursePrerequisites(prerequisites(i)(0)) == 0) {
            result = result :+ prerequisites(i)(0)
            queue.enqueue(prerequisites(i)(0))
          }
        }
      })
    }

    //If length of result = numCourses return result else return empty array
    if (numCourses == result.length) {
      return result
    } else {
      return Array[Int]()
    }
  }

  // Course Schedule I - Can Complete all courses - return Boolean
  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    if (prerequisites.isEmpty || numCourses == 0) return true

    var coursePrerequisites: Array[Int] = Array.fill[Int](numCourses)(0)
    for (i <- prerequisites.indices) {
      coursePrerequisites(prerequisites(i)(0)) += 1
    }

    var queue: mutable.Queue[Int] = mutable.Queue()
    for (i <- coursePrerequisites.indices) {
      if (coursePrerequisites(i) == 0) queue.enqueue(i)
    }

    var size = queue.length

    while (queue.nonEmpty) {
      var currentCourse = queue.dequeue()
      for (i <- prerequisites.indices) {
        if (prerequisites(i)(1) == currentCourse) {
          coursePrerequisites(prerequisites(i)(0)) -= 1
          if (coursePrerequisites(prerequisites(i)(0)) == 0) {
            size += 1
            queue.enqueue(prerequisites(i)(0))
          }
        }
      }
    }
    return size == numCourses
  }
}
