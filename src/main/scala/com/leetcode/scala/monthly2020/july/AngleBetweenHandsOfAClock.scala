package com.leetcode.scala.monthly2020.july

/*
* Given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand.
*
* */

/*
* Input: hour = 12, minutes = 30
  Output: 165
*
* Input: hour = 3, minutes = 30
  Output: 75
*
* Input: hour = 3, minutes = 15
  Output: 7.5
*
* Input: hour = 4, minutes = 50
  Output: 155
*
* Input: hour = 12, minutes = 0
  Output: 0
*
* Constraints:
  * 1 <= hour <= 12
  * 0 <= minutes <= 59
  * Answers within 10^-5 of the actual value will be accepted as correct.
*
* */

/*
* Approach: Mathematical
*
* First, We have to determine the angle of hour hand and minute hand with respect to 12.
* Take the absolute difference between the angles.
* Return the min of (360-abs(hour_angle - minute angle)) and abs(hour_angle - minute angle)
*
* Hour Angle Calculation:
* Hour Angle = (Hour * 60 + Minutes)/2
*
*
* Minutes Angle Calculation:
* Minutes Angle = Minutes * 6
*
* Note: While calculating hour angle we need to consider if hour is 12 we need to assume it as 0 and while calculating minutes angle when minutes is 60 we need to assume it as 0.
*
* @link: https://leetcode.com/explore/featured/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3390/
*
* */


object AngleBetweenHandsOfAClock {
  def main(args: Array[String]): Unit = {
    val (hour: Int, minutes: Int) = (12, 30)
    val result = angleClock(hour, minutes)
    println(s"Result: ${result}, ${result == 165}")
    val (hour1: Int, minutes1: Int) = (1, 57)
    val result1 = angleClock(hour1, minutes1)
    println(s"Result: ${result1}, ${result1 == 76.5}")
  }

  def angleClock(hour: Int, minutes: Int): Double = {
    val calulatedHour: Double = if (hour == 12) 0d else hour.toDouble
    val calulatedMinutes: Double = if (minutes == 60) 0d else minutes.toDouble
    val hourAngle = (calulatedHour * 60 + calulatedMinutes) / 2
    val minutesAngle = calulatedMinutes * 6
    val angleDifference: Double = math.abs(hourAngle - minutesAngle)
    return angleDifference min 360 - angleDifference
  }
}
