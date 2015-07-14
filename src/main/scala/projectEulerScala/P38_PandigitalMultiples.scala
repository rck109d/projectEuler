package main.scala.projectEulerScala

// 932718654
object P38_PandigitalMultiples {
  def concatenatedProduct(num: Int, top: Int): BigInt = BigInt((1 to top).map(_ * num).mkString)

  def isPandigital(n: BigInt): Boolean = {
    val ns = n.toString()
    ns.length == 9 && (1 to 9).forall(x => ns.contains(x.toString))
  }

  def main(args: Array[String]) {
    val max = (1 to 9999).flatMap { num =>
      (1 to 9).map { top =>
        concatenatedProduct(num, top)
      }.filter(isPandigital)
    }.max
    println(max)
  }
}
