package main.scala.projectEulerScala

// 4179871
object P23_NonAbundantSums {
  def divisors(n: Int) = (1 to n - 1).filter(n % _ == 0)

  def main(args: Array[String]) {
    val range: Int = 28123 // 28123
    val abundantNumbers = (1 to range).filter(n => divisors(n).sum > n).toList.toSet
    // missed numbers are those such that no two abundant numbers sum to equal
    val missedNumbers = (1 to 28123).filter { n: Int =>
      !(1 to n - 1).exists { part: Int =>
        abundantNumbers.contains(part) && abundantNumbers.contains(n - part)
      }
    }
    println(missedNumbers.sum)
  }
}
