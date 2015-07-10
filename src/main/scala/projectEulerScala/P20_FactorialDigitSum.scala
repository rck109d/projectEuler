package main.scala.projectEulerScala

import scala.annotation.tailrec

// 648
object P20_FactorialDigitSum {
  def fac(n:Int): BigInt = {
    @tailrec
    def loop(n:BigInt, acc:BigInt): BigInt = if(n <= 0) acc else loop(n - 1, acc * n)
    loop(n, 1)
  }
  def main(args: Array[String]) {
    val x: BigInt = fac(100)
    val what = fac(100).toString().map(_.toString()).map(Integer.parseInt(_, 10)).sum
    println(what)
  }
}
