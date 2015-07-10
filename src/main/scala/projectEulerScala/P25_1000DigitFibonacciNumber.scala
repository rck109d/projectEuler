package main.scala.projectEulerScala

import scala.collection.mutable

// 4782
object P25_1000DigitFibonacciNumber {
  var memo = mutable.Map[Int, BigInt]()

  def f(n: Int): BigInt = {
    if (n <= 2)
      return 1
    else if (memo.contains(n))
      return memo(n)
    val result: BigInt = f(n - 1) + f(n - 2)
    memo(n) = result
    result
  }

  def main(args: Array[String]) {
    var len: Int = 0
    var n: Int = 4
    while (len < 1000) {
      n += 1
      len = f(n).toString.length
    }
    println(n + " " + len)
  }
}
