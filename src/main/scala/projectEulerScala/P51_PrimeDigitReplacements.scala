package main.scala.projectEulerScala

// 121313
object P51_PrimeDigitReplacements {
  def isPrime(n: Int): Boolean = n > 1 && (2 to math.ceil(math.sqrt(n)).toInt).forall(n % _ != 0)

  val primeStream: Stream[Int] = 2 #:: Stream.from(3, 2).filter { i =>
    primeStream.takeWhile(j => j * j <= i).forall(j => i % j > 0)
  }

  def primeReplacementsMaxFamily(n: Int): Seq[Int] = {
    val ns = n.toString
    val nsLength = ns.length

    (1 to nsLength).map { numReplacements =>
      (0 until nsLength).combinations(numReplacements).map { replacementPositions =>
        (0 to 9).map(_.toString).map { replacement =>
          ns.zipWithIndex.map { charAndPos =>
            if (replacementPositions.contains(charAndPos._2)) replacement
            else charAndPos._1
          }.mkString.toInt
        }.filter { n =>
          n.toString.length == nsLength && isPrime(n)
        }
      }.toList.maxBy(_.size)
    }.maxBy(_.size)
  }

  def main(args: Array[String]) {
    val ans = primeStream.map(primeReplacementsMaxFamily).find(_.size >= 8).get
    println(ans)
    println(ans.head)
  }
}
