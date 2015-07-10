package main.scala.projectEulerScala

// 40730
object P34_DigitFactorials {
  def factorial(n: Int): Int = if (n == 0) 1 else n * factorial(n - 1)

  def euler34 = {
    (3 to 100000).toSeq.filter { n: Int =>
      val digits: Array[Int] = n.toString.toCharArray.map(c => Integer.parseInt(c.toString, 10))
      val digitsFactorialSum: Int = digits.map(factorial).sum
      digitsFactorialSum == n
    }.sum
  }

  def main(args: Array[String]) {
    println(euler34)
  }
}
