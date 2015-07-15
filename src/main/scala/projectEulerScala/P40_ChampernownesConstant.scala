package main.scala.projectEulerScala

// 210
object P40_ChampernownesConstant {
  def main(args: Array[String]) {
    val champ = "0" + (1 to 200000).map(_.toString).mkString
    val p = (0 to 6).map(math.pow(10, _).toInt).map(champ(_).asDigit).product
    println(p)
  }
}
