package main.scala.projectEulerScala

// 200 -> 73682
object P31_CoinSums {
  def main(args: Array[String]) {
    val sum = 2000000
    val start = System.currentTimeMillis()
    val ways = Array.fill(sum + 1)(BigInt(0))
    ways(0) = 1
    for (coin <- Seq(1, 2, 5, 10, 20, 50, 100, 200); i <- 0 to sum; x = i - coin) if (x >= 0) ways(i) += ways(x)
    println(ways(sum))
    println(System.currentTimeMillis() - start)
  }
}
