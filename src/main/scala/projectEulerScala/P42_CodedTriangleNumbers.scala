package main.scala.projectEulerScala

import scala.io.Source

// 162
object P42_CodedTriangleNumbers {
  val words = Source.fromFile("data/p042_words.txt").mkString
    .split(",").map(s => s.replaceAll("\"", ""))

  def wordValue(word: String) = word.map(c => c.toUpper.toInt - 65 + 1).sum

  val triangles = (1 to 20).map(n => n * (n + 1) / 2)

  def main(args: Array[String]) {
    println(words.count(w => triangles.contains(wordValue(w))))
  }
}
