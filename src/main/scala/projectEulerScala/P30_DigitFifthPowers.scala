package main.scala.projectEulerScala

// 443839
object P30_DigitFifthPowers {
  def digits(n:Int): Seq[Int] = n.toString.toCharArray.map(_.toString).map(Integer.parseInt(_,10))
  def digitsPowerSum(digits:Seq[Int], pow: Int) = digits.map(BigInt(_)).map(_.pow(pow)).sum
  def working(pow: Int): Set[Int] = 1.to(1000000).filter{
    n:Int => digitsPowerSum(digits(n), pow) == n
  }.toSet - 1
  def main(args: Array[String]) {
    println(working(5).sum)
  }
}
