package basics

object ForYieldComprehension extends App {

  def forYield(list: List[Int], list2: List[Int]): List[Int] = {

    for {
      l <- list
      l2 <- list2
    } yield l + l2
  }

  def flatMapAndMap(list: List[Int], list2: List[Int]): List[Int] = {

    list flatMap { i =>

      list2 map { j =>

        i + j
      }
    }
  }

  override def main(args: Array[String]): Unit = {

    val list1 = List(1, 2, 3, 4, 5)
    val list2 = List(1, 2, 3, 4, 5)

    val list3 = forYield(list1, list2)
    val list4 = flatMapAndMap(list1, list2)

    println(s"List 3 is => ${list3}")
    println(s"List 4 is => ${list4}")
  }

}
