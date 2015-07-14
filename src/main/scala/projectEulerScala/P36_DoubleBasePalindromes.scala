package main.scala.projectEulerScala

// 872187
object P36_DoubleBasePalindromes {
  def main(args: Array[String]) {
    val sum =(1 until 1000000).filter{n =>
      val s = n.toString
      s == s.reverse
    }.filter { n =>
      val bin:String = n.toBinaryString
      bin == bin.reverse
    }.sum
    println(sum)
  }
}
