package main.scala.projectEulerScala

// 21124
object P17_NumberLetterCounts {
  def words: Map[Int, String] = Map(
    1 -> "one",
    2 -> "two",
    3 -> "three",
    4 -> "four",
    5 -> "five",
    6 -> "six",
    7 -> "seven",
    8 -> "eight",
    9 -> "nine",
    10 -> "ten",
    11 -> "eleven",
    12 -> "twelve",
    13 -> "thirteen",
    14 -> "fourteen",
    15 -> "fifteen",
    16 -> "sixteen",
    17 -> "seventeen",
    18 -> "eighteen",
    19 -> "nineteen",
    20 -> "twenty",
    30 -> "thirty",
    40 -> "forty",
    50 -> "fifty",
    60 -> "sixty",
    70 -> "seventy",
    80 -> "eighty",
    90 -> "ninety"
  )

  def numToWordsUnder100(num: Int): String = {
    val b: StringBuilder = new StringBuilder()
    val lastTwoDigits: Int = num % 100
    if (lastTwoDigits > 0) {
      if (lastTwoDigits < 20) {
        b.append(words(lastTwoDigits))
      } else {
        val tens: Int = lastTwoDigits / 10 * 10
        b.append(words(tens))
        val units: Int = lastTwoDigits % 10
        if (units != 0) {
          b.append("-" + words(units))
        }
      }
    }
    b.toString()
  }

  def numToWordsHundreds(num: Int): String = {
    if(num < 100) "" else words(num / 100) + " hundred"
  }

  def numToWords(num: Int): String = {
    require(num >= 0)
    if(num >= 1000) {
      return "one thousand"
    }
    val b: StringBuilder = new StringBuilder()
    val hundreds: String = numToWordsHundreds(num)
    val under100: String = numToWordsUnder100(num)
    if(!hundreds.isEmpty) {
      b.append(hundreds)
    }
    if(!under100.isEmpty) {
      if(!b.isEmpty) {
        b.append(" and")
      }
      b.append(" " + under100)
    }
    b.toString()
  }

  def main(args: Array[String]): Unit = {
    var charsUsed = 0
    (1 to 1000).foreach { n: Int =>
      val words: String = numToWords(n)
      println(n + " " + words)
      words.foreach { c =>
        if(c.toString().matches("""[a-zA-Z]""")) {
          charsUsed += 1
        }
      }
    }
    println(charsUsed)
  }
}
