package main.scala.projectEulerScala

import scala.annotation.tailrec

// 4075
object P53_CombinatoricSelections {
  def main(args: Array[String]) {
    val x = (1 to 100).map { n =>
      (1 to n).count { r =>
        fac(n) / fac(r) / fac(n - r) > 1000000
      }
    }.sum
    println(x)
  }

  @tailrec
  def fac(n: BigInt, acc: BigInt = 1): BigInt = {
    if (n == BigInt(0)) acc else fac(n - 1, n * acc)
  }
}
