package main.scala.projectEulerScala

// 31626
object P21_AmicableNumbers {
  def d(n: Int): Int = {
    (1 to n-1).filter(n % _ == 0).sum
  }
  def main(args: Array[String]) {
    var amicableNumbers: Set[Int] = Set()
    (1 to 10000).foreach { n: Int =>
      val dOfN = d(n)
      if(dOfN != n && d(dOfN) == n) {
        println(n + " " + dOfN)
        amicableNumbers += n
        amicableNumbers += dOfN
      }
    }
    println("amicableNumbers: " + amicableNumbers)
    println("amicableNumbers.sum: " + amicableNumbers.sum)
  }
}
