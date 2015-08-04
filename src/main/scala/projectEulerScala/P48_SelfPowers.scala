package main.scala.projectEulerScala

// 9110846700
object P48_SelfPowers {
  def main(args: Array[String]) {
    val ans = (1 to 1000).map { n =>
      BigInt(n).pow(n)
    }.sum.toString().takeRight(10)
    println(ans)
  }
}
