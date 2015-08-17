package main.scala.projectEulerScala

// 997651
object P50_ConsecutivePrimeSum {
  def isPrime(n: Int): Boolean = n > 1 && (2 to math.ceil(math.sqrt(n)).toInt).forall(n % _ != 0)

  val primeStream: Stream[Int] = 2 #:: Stream.from(3, 2).filter { i =>
    primeStream.takeWhile(j => j * j <= i).forall(j => i % j > 0)
  }

  def main(args: Array[String]) {
    val limit = 1000000
    val primes = primeStream.takeWhile(_ < limit)
    val ans = (2 to 1000).map { num =>
      val sum = primes.iterator.sliding(num).map(_.sum).takeWhile(_ < limit).find(isPrime)
      (sum.getOrElse(0), num)
    }.filter(_._1 > 0).maxBy(_._2)
    println(s"prime: ${ans._1}, number of terms: ${ans._2}")
  }
}
