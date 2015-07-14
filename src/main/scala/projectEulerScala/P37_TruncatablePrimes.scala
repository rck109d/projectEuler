package main.scala.projectEulerScala

import scala.collection.immutable.HashSet

// 748317
object P37_TruncatablePrimes {
  val primeStream: Stream[Int] = 2 #:: Stream.from(3, 2).filter { i =>
    primeStream.takeWhile(j => j * j <= i).forall(j => i % j > 0)
  }
  val primes = HashSet() ++ (0 to 70000).map(primeStream.drop(_).head)

  def stringIsPrime(s: String): Boolean = primes.contains(s.toInt)

  def isTruncatablePrime(n: Int): Boolean = {
    val ns = n.toString
    ns.tails.filter(_.length > 0).forall(stringIsPrime) &&
      ns.inits.filter(_.length > 0).forall(stringIsPrime)
  }

  def main(args: Array[String]) {
    val tp = primes.filter(_ > 7).filter(isTruncatablePrime)
    println(tp)
    println(tp.sum)
  }
}
