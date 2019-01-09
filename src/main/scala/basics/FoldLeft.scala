package basics

object FoldLeft extends App {


  def sum(list: List[Int]): Int = list.foldLeft(0) {
    (left, right) => left + right
  }

  def length[T](list: List[T]): Int = list.foldLeft(0) {
    (left, _) => left + 1
  }

  def first[T](list: List[T]): T = list.foldLeft(list.head) {
    (left, _) => left
  }

  def last[T](list: List[T]): T = list.foldLeft(list.head) {
    (_, right) => right
  }

  def concatenate(list: List[String]): String = list.foldLeft("") {
    (left, right) => s"${left + right}"
  }

  override def main(args: Array[String]): Unit = {

    val intList: List[Int] = List(1, 2, 3, 4, 5, 6)
    val stringList: List[String] = List("Joe", "Blogs")

    println(s"The sum of the list is ${sum(intList)}")
    println(s"The length of the list is ${length(intList)}")
    println(s"The first element in the list is ${first(intList)}")
    println(s"The last element in the list is ${last(intList)}")
    println(s"The concatenated string is ${concatenate(stringList)}")
  }
}
