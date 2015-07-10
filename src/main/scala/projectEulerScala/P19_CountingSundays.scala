package main.scala.projectEulerScala

import java.time.{DayOfWeek, LocalDate}

// 171
object P19_CountingSundays {
  def main(args: Array[String]) {
    var d: LocalDate = LocalDate.of(1901, 1, 1)
    var num: Int = 0
    val to: LocalDate = LocalDate.of(2000, 12, 31)
    while(d.isBefore(to)) {
      if(d.getDayOfWeek == DayOfWeek.SUNDAY && d.getDayOfMonth == 1) {
        num += 1
      }
      d = d.plusDays(1)
    }
    println(num)
  }
}
