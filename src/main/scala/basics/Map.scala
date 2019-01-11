package basics

object Map extends App {

  def square(list: List[Int]): List[Int] = list.map {
    (x) => x * 2
  }

  def cubed(list: List[Int]): List[Int] = list.map {
    (x) => x * 3
  }

  override def main(args: Array[String]): Unit = {

    val intList: List[Int] = List(1, 2, 2, 3, 4, 5, 6)

    println(s"The intList transformed with a square function applied is ${square(intList)}")
    println(s"The intList transformed with a cubed function applied is ${cubed(intList)}")
  }
}
