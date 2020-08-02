package com.leetcode.scala.monthly2020.august

import scala.collection.mutable

/*
* Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
* Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
* It is possible that several messages arrive roughly at the same time.
*
* */

/*
* Logger logger = new Logger();

// logging string "foo" at timestamp 1
logger.shouldPrintMessage(1, "foo"); returns true;

// logging string "bar" at timestamp 2
logger.shouldPrintMessage(2,"bar"); returns true;

// logging string "foo" at timestamp 3
logger.shouldPrintMessage(3,"foo"); returns false;

// logging string "bar" at timestamp 8
logger.shouldPrintMessage(8,"bar"); returns false;

// logging string "foo" at timestamp 10
logger.shouldPrintMessage(10,"foo"); returns false;

// logging string "foo" at timestamp 11
logger.shouldPrintMessage(11,"foo"); returns true;
* */


class Logger {

  //Initialize your data structure here.
  private var map: mutable.HashMap[String, Int] = mutable.HashMap()
  private var limiter: Int = 10


  /* Returns true if the message should be printed in the given timestamp, otherwise returns false.
  If this method returns false, the message will not be printed.
  The timestamp is in seconds granularity.
  */
  def shouldPrintMessage(timestamp: Int, message: String): Boolean = {
    if (!map.contains(message)) {
      map += (message -> timestamp)
      return true
    } else {
      if ((timestamp - map(message)) >= limiter) {
        map += (message -> timestamp)
        return true
      }
    }
    return false
  }
}

object LoggerRateLimiter {

  def main(args: Array[String]): Unit = {
    val logger: Logger = new Logger()
    logger.shouldPrintMessage(1, "foo")
    logger.shouldPrintMessage(2, "bar")
    logger.shouldPrintMessage(3,"foo")
    logger.shouldPrintMessage(8,"bar")
    logger.shouldPrintMessage(10,"foo")
    logger.shouldPrintMessage(11,"foo")
  }
}
