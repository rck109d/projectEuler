package main.scala.projectEulerScala

import scala.collection.mutable

// 55 circular primes less than 1000000
object P35_CircularPrimes {
  val primeStream: Stream[Int] = 2 #:: Stream.from(3, 2).filter { i =>
    primeStream.takeWhile(j => j * j <= i).forall(j => i % j > 0)
  }
  val primeCache = mutable.LinkedHashSet(primeStream.head)
  var primeCacheMax = primeCache.max
  var primeCacheIndex = 0

  def isPrime(n: Int): Boolean = {
    if (n < 2) return false
    while (n > primeCacheMax) {
      primeCacheIndex += 1
      primeCacheMax = primeStream.drop(primeCacheIndex).head
      primeCache.add(primeCacheMax)
    }
    primeCache.contains(n)
  }

  def circles(s: String): Set[String] = s.inits.toList zip s.tails.toSeq.reverse map (z => z._2 + z._1) toSet

  def isCircularPrime(n: Int): Boolean = circles(n.toString).map(s => Integer.parseInt(s, 10)).forall(isPrime)

  def main(args: Array[String]): Unit = {
    val top = 1000000
    val circularPrimesUnderTop = (2 until top).filter(isCircularPrime)
    println(circularPrimesUnderTop)
    println(circularPrimesUnderTop.size + " found")
  }
}
