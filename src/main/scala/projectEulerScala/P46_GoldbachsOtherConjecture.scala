package main.scala.projectEulerScala

// 5777
object P46_GoldbachsOtherConjecture {
  def isEven(n: Int): Boolean = n % 2 == 0

  def isPrime(n: Int): Boolean = n > 1 && (2 to math.sqrt(n).ceil.toInt).forall(n % _ != 0)

  def conjecture(n: Int): Boolean = {
    (1 to math.sqrt(n).floor.toInt).exists { x: Int =>
      isPrime(n - 2 * x * x)
    }
  }

  def main(args: Array[String]) {
    val ans = Stream.from(3, 2).dropWhile(n => isEven(n) || isPrime(n) || conjecture(n)).head
    println(ans)
  }
}
