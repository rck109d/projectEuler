package main.scala.projectEulerScala

import scala.collection.mutable

// -59231
object P27_QuadraticPrimes {
  def isPrimeDef(n:Int): Boolean = !(2 to n/2).exists(n % _ == 0)
  val isPrime:mutable.Map[Int, Boolean] = mutable.Map().withDefault(isPrimeDef)
  def countConsecutivePrimes(a: Int, b: Int): Int = {
    def f(n: Int) = n * n + a * n + b
    var n = 0
    var failed = false
    while(!failed) {
      if(!isPrime(f(n).abs)) failed = true
      else n += 1
    }
    n
  }
  def main(args: Array[String]) {
    val range = -1000 to 1000
    val counts = for (a <- range; b <- range) yield (a,b,countConsecutivePrimes(a,b))
    val best = counts.maxBy(t => t._3)
    println(best)
    println(best._1 * best._2)
  }
}
