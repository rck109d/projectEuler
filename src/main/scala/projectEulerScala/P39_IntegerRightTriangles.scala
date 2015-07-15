package main.scala.projectEulerScala

// 840
object P39_IntegerRightTriangles {
  def countRightTrianglesWithPerimeter(p: Int): Int = {
    var count = 0
    for {
      a <- 3 to p
      b <- 3 to a
      c = p - a - b
      if a * a + b * b == c * c
    } count += 1
    count
  }

  def main(args: Array[String]) {
    println((12 until 1000).maxBy(countRightTrianglesWithPerimeter))
  }
}
