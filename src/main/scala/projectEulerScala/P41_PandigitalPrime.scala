package main.scala.projectEulerScala

// 7652413
object P41_PandigitalPrime {
  def isPrime(n: Int): Boolean = n > 1 && (2 to math.ceil(math.sqrt(n)).toInt).forall(n % _ != 0)

  def main(args: Array[String]) {
    val best = (1 to 9).reverse.map { n =>
      (1 to n).reverse.mkString
    }.flatMap { s =>
      s.permutations.filter(x => isPrime(x.toInt))
    }.max
    println(best)
  }
}
