package basics

object Fold extends App {

  def sum(list: List[Int]): Int = list.fold(0) {
    (left, right) => left + right
  }

  override def main(args: Array[String]): Unit = {

    val intList: List[Int] = List(1, 2, 2, 3, 4, 5, 6)

    println(s"The sum of the intList is ${sum(intList)}")
  }
}
