package main.scala.projectEulerScala

object P29_DistinctPowers {
  def main(args: Array[String]) {
    val range = 2 to 100
    val powers:Set[BigInt] = (for(a <- range; b <- range) yield BigInt(a).pow(b)).toSet
    println(powers.size)
  }
}
