package main.scala.projectEulerScala

import scala.annotation.tailrec
import scala.collection.mutable

object Collatz {
  val memo: mutable.Map[BigInt, Int] = mutable.HashMap()
  def countSteps(n: BigInt): Int = {
    @tailrec
    def countStepsAcc(acc: Int, n: BigInt): Int = {
      if (n <= 1) {
        acc
      } else {
        val next: BigInt = if (n % 2 == 0) n / 2 else 3 * n + 1
        countStepsAcc(acc + 1, next)
      }
    }
    if(memo.contains(n)) {
      memo(n)
    } else {
      val steps = countStepsAcc(1, n)
      memo += n -> steps
      steps
    }
  }
  def main(args: Array[String]): Unit = {
    var argMax: Int = 0
    var max: Int = 0
    (1 to 1000000).foreach { n:Int =>
      val steps:Int = countSteps(n)
      if(steps > max) {
        argMax = n
        max = steps
      }
    }
    println(argMax + " " + max)
  }
}
