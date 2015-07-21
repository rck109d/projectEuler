package main.scala.projectEulerScala

// 16695334890
object P43_SubstringDivisibility {
  def main(args: Array[String]) {
    val primes = Stream(2, 3, 5, 7, 11, 13, 17)
    val primesMap = (1 to 7).zip(primes).toMap
    val answer = "0123456789".permutations.filter { s =>
      (1 to 7).forall { i =>
        s.substring(i, i + 3).toInt % primesMap(i) == 0
      }
    }.map(_.toLong).sum
    println(answer)
  }
}
