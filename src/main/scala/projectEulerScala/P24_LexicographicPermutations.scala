package main.scala.projectEulerScala

//2783915460
object P24_LexicographicPermutations {
  def main(args: Array[String]) {
    val digits: List[String] = (0 to 9).map(_.toString).toList
    digits.permutations.zipWithIndex.foreach { case (s, i) =>
      if(i+1 == 1000000) {
        println(s.mkString(""))
        System.exit(0)
      }
    }
  }
}
