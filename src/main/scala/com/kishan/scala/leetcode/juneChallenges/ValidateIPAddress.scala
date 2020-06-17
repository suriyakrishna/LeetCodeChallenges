package com.kishan.scala.leetcode.juneChallenges


/*
* Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
* IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
* Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
*
* IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
* However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
* Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
*
* Note: You may assume there is no extra space or special characters in the input string.
*
* */

/*
* Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
  Output: "IPv6"
  Explanation: This is a valid IPv6 address, return "IPv6".
*
* Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
  Output: "IPv6"
  Explanation: This is a valid IPv6 address, return "IPv6".
*
* Input: "256.256.256.256"
  Output: "Neither"
  Explanation: This is neither a IPv4 address nor a IPv6 address.
* */


/*
* Approach:
*
* Since we are not going to have any other special characters or alphabets other than Hexadecimal we are good to validate with our approach.
*
* validateIPv4 Function:
* 1. We will check string has all four required part.
* 2. For each number part, First, we will check each number part length is greater than 0 and less than or equal to 3 and We will check each number part which has more than 1 digit should not start with 0.
* 3. Finally we will iterate through each character of the string and will generate number. While iterating we will check if the character lies between 0 and 9. If not we will return false.
* 4. Then, we will check if the number lies between 0 and 255 if the number doesn't lies between 0 and 255. We will return false.
*
* validateIPv6 Function:
* 1. We will check string has all eight required part.
* 2. For each part, First, we will check the length is between 1 and 4.
* 3. Then, we will iterate through each character and will check the character lies between [0,9], [a,e] and [A,E]. If not we will return false.
*
* validIPAddress Function: This is driver function.
* 1. If string contains `.` we have to use IPv4 validation.
* 2. If string contains `:` we have to use IPv6 validation.
* 3. Else the string will be neither.
* */


object ValidateIPAddress {
  def main(args: Array[String]): Unit = {
    val IPv4 = "172.16.254.1"
    val IPv4_InValid = "172.16.254.01"
    val IPv6 = "2001:0db8:85a3:0:0:8A2E:0370:7334"
    val IPv6_InValid = "02001:0db8:85a3:0000:0000:8a2e:0370:7334"
    println(validIPAddress(IPv4) == "IPv4")
    println(validIPAddress(IPv4_InValid) == "Neither")
    println(validIPAddress(IPv6) == "IPv6")
    println(validIPAddress(IPv6_InValid) == "Neither")


  }

  def validIPAddress(IP: String): String = {
    if (IP.contains(".")) {
      if (validateIPv4(IP)) "IPv4" else "Neither"
    } else if (IP.contains(":")) {
      if (validateIPv6(IP)) "IPv6" else "Neither"
    } else {
      "Neither"
    }
  }

  def validateIPv4(IP: String): Boolean = {
    if (IP.charAt(IP.length() - 1) == '.') return false
    val ip = IP.split("\\.")
    if (ip.length != 4) return false
    ip.foreach(number => {
      if (number.length == 0 || number.length > 3) return false
      if (number.length > 1 && number.charAt(0) == '0') return false
      var num = 0
      number.foreach(char => {
        if (char < '0' || char > '9') return false
        num = num * 10 + (char - '0')
      })
      if (num < 0 || num > 255) return false
    })
    return true
  }

  def validateIPv6(IP: String): Boolean = {
    if (IP.charAt(IP.length() - 1) == ':') return false
    val ip = IP.split(":")
    if (ip.length != 8) return false
    ip.foreach(number => {
      if (number.length == 0 || number.length > 4) return false
      number.foreach(char => {
        if ((char < '0' || char > '9') && (char < 'a' || char > 'f') && (char < 'A' || char > 'F')) return false
      })
    })
    return true
  }


  def stringToNum(string: String): Int = {
    var num = 0
    string.foreach(char => {
      num = num * 10 + (char - '0')
    })
    num
  }


}
