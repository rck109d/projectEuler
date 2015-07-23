package main.scala.projectEulerScala

import scala.annotation.tailrec

// 134043
object P47_DistinctPrimeFactors {
  val primes: Stream[Int] = 2 #:: Stream.from(3, 2).filter { i =>
    primes.takeWhile(j => j * j <= i).forall(j => i % j > 0)
  }

  def distinctPrimeFactors(num: Int) = {
    @tailrec
    def loop(n: Int, acc: Set[Int]): Set[Int] = {
      if (n == 1) {
        acc + 1
      } else {
        val factor = primes.find(n % _ == 0).get
        if (factor == n) {
          acc + 1
        } else {
          loop(n / factor, acc + factor)
        }
      }
    }
    loop(num, Set())
  }

  val factorStream = Stream.from(1).map(n => (n, distinctPrimeFactors(n)))

  def factorStreamConsecutive(n: Int) = factorStream.sliding(n).filter { s =>
    s.forall(_._2.size == n) // each has factors size n
  }.map(_.toList)

  def main(args: Array[String]) {
    val window = factorStreamConsecutive(4).next()
    val answer = window.map(_._1).min
    println(answer)
  }
}
