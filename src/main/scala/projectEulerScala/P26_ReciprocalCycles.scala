package main.scala.projectEulerScala

import scala.collection.mutable

// 983
object P26_ReciprocalCycles {
  def unitFractionCycleLength(divisor: Int): Int = {
    var remainder: Int = 1
    val remainderVisits: mutable.Map[Int, Int] = mutable.Map().withDefaultValue(0)
    while (remainder != 0) {
      if (remainderVisits(remainder) > 1) {
        return remainderVisits.values.count(_ > 1)
      }
      remainderVisits(remainder) += 1
      if (divisor > remainder) {
        remainder *= 10
      }
      if (remainder > divisor) {
        val into: Int = remainder / divisor
        remainder -= into * divisor
      }
    }
    0
  }

  def main(args: Array[String]) {
    val counts = (2 to 999).map(x => (x, unitFractionCycleLength(x)))
    println(counts.maxBy(t => t._2))
  }
}
