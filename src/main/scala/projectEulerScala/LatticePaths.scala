package main.scala.projectEulerScala

import scala.collection.mutable

object LatticePaths {
  val memo: mutable.Map[(Int, Int), BigInt] = mutable.HashMap()

  def count(x: Int, y: Int): BigInt = {
    val key = (x, y)
    if (x == 0 || y == 0) {
      memo(key) = 1
    } else if (!memo.contains(key)) {
      memo(key) = count(x - 1, y) + count(x, y - 1)
    }
    memo(key)
  }

  def main(args: Array[String]): Unit = {
    println(count(20, 20))
  }
}
