package main.scala.projectEulerScala

// 1533776805
object P45_TriangularPentagonalAndHexagonal {
  def pentagonal = Stream.from(1).map(n => n.toLong * (3 * n - 1) / 2)

  def hexagonal = Stream.from(1).map(n => n.toLong * (2 * n - 1))

  def intersect(a: Stream[Long], b: Stream[Long]): Stream[Long] = (a, b) match {
    case (ahead #:: as, bhead #:: bs) =>
      if (ahead < bhead) intersect(as, b)
      else if (ahead > bhead) intersect(a, bs)
      else ahead #:: intersect(as, bs)
  }

  def main(args: Array[String]) {
    val joined = intersect(pentagonal, hexagonal)
    println(joined.dropWhile(_ <= 40755).head)
  }
}
