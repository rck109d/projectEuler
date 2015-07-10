package main.scala.projectEulerScala

object PowerDigitSum {
  def main(args:Array[String]): Unit = {
    println(
      BigInt(2).pow(1000).toString().map { c =>
        Integer.parseInt(c.toString(), 10)
      }.sum
    )
  }
}
