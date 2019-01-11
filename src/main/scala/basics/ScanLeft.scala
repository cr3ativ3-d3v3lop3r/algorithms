package basics

object ScanLeft extends App {

  def runningTotal(list: List[Int]): List[Int] = list.scanLeft(0) {
    (left, right) => left + right
  }

  override def main(args: Array[String]): Unit = {

    val intList: List[Int] = List(1, 2, 2, 3, 4, 5, 6)

    println(s"The running total of the intList is ${runningTotal(intList)}")
  }
}
