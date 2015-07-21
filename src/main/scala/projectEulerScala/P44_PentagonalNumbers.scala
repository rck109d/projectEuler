package main.scala.projectEulerScala

object P44_PentagonalNumbers {
  val cache = (1 to 5000).map(n => n * (3 * n - 1) / 2).toSeq

  def isPentagonal(n: Int) = ((1 + math.sqrt(1 + 24 * n)) / 6).isWhole()

  def main(args: Array[String]) {
    for {
      a <- cache
      b <- cache
      if a > b && isPentagonal(a + b) && isPentagonal(math.abs(a - b))
    } {
      println(a - b)
      System.exit(0)
    }
  }
}
