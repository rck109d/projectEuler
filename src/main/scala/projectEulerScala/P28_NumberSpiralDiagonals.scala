package main.scala.projectEulerScala

// 669171001
object P28_NumberSpiralDiagonals {

  object Direction extends Enumeration {
    val Up, Down, Left, Right = Value
  }

  def spiral(size: Int): Array[Array[Int]] = {
    val arr = Array.fill(size, size)(0)
    var x, y = size / 2
    var n = 1
    var dir = Direction.Up
    while (n <= size * size && x >= 0 && x < size && y >= 0 && y < size) {
      arr(y)(x) = n
      dir match {
        case Direction.Up => if (arr(y)(x + 1) == 0) dir = Direction.Right
        case Direction.Down => if (arr(y)(x - 1) == 0) dir = Direction.Left
        case Direction.Left => if (arr(y - 1)(x) == 0) dir = Direction.Up
        case Direction.Right => if (arr(y + 1)(x) == 0) dir = Direction.Down
      }
      dir match {
        case Direction.Up => y -= 1
        case Direction.Down => y += 1
        case Direction.Left => x -= 1
        case Direction.Right => x += 1
      }
      n += 1
    }
    arr
  }

  def printArray(arr: Array[Array[Int]]): Unit = {
    val numWidth: Int = arr.map(_.max).max.toString.length
    val s = arr.map { a: Array[Int] =>
      a.map { i: Int =>
        i.toString.reverse.padTo(numWidth, ' ').reverse
      }.mkString(" ")
    }.mkString("\n")
    println(s)
  }

  def main(args: Array[String]): Unit = {
    val size: Int = 1001
    val arr = spiral(size)
//    printArray(arr)
    val nwse = for (i <- 0 to size - 1) yield arr(i)(i)
    val swne = for (i <- 0 to size - 1) yield arr(i)(size - i - 1)
    println(nwse.sum + swne.sum - 1)
  }
}
