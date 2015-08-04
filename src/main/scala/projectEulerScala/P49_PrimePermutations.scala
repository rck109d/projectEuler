package main.scala.projectEulerScala

// 296962999629
object P49_PrimePermutations {
  val primes: Stream[Int] = 2 #:: Stream.from(3, 2).filter { i =>
    primes.takeWhile(j => j * j <= i).forall(j => i % j > 0)
  }

  def isPrime(n: Int): Boolean = n > 1 && (2 to math.sqrt(n).ceil.toInt).forall(n % _ != 0)

  def main(args: Array[String]) {
    // primes strings of length 4
    primes.map(_.toString).dropWhile(_.length < 4).takeWhile(_.length == 4).map { numString =>
      // prime string permutations which are also prime (and length 4, e.g. 0XXX is only length 3)
      numString.permutations.map(_.toInt).filter(isPrime).filter(_.toString.length == 4).toSeq.sorted
    }.flatMap { primePermutations =>
      // flat map to all 3-combinations of all-prime permutations
      primePermutations.combinations(3)
    }.distinct.filter { nums =>
      // distinct combinations, sliding pairs where differences are all identical (i.e. set of size 1)
      nums.sliding(2).map(t => t(1) - t.head).toSet.size == 1
    }.map {
      // concat all prime strings for 12-character encodings
      _.mkString
    }.foreach(println)
  }
}
