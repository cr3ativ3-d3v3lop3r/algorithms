package basics

object Loops extends App {

  def toLoopIncreasing(times: Int): Unit = {

    (0 until times).map { i =>
      println(s"to loop increasing => i is $i")
    }
  }

  def toLoopDecreasing(times: Int): Unit = {

    (times until 0 by -1).map { i =>
      println(s"to loop decreasing => is is $i")
    }
  }

  def forEach(times: Int): Unit = {

    (0 until times).foreach { i =>
      println(s"for each increasing => $i")
    }
  }

  def forLoopIncreasing(times: Int): Unit = {

    for(i <- 0 to times) {
      println(s"for loop increasing => i is $i")
    }
  }

  def forLoopDecreasing(times: Int): Unit = {

    for(i <- times to 0 by -1) {
      println(s"for loop decreasing => i is $i")
    }
  }

  def foldLeft(times: Int): Int = {

    (0 until times).foldLeft(0) { (acc, elem) =>
      acc + elem
    }
  }

  override def main(args: Array[String]): Unit = {

    toLoopIncreasing(10)
    toLoopDecreasing(10)
    forLoopIncreasing(10)
    forLoopDecreasing(10)
    forEach(10)

    println(foldLeft(100000000))
  }
}
