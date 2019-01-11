package basics

object FoldRight extends App {

  def sum(list: List[Int]): Int = list.foldRight(0) {
    (left, right) => right + left
  }

  def length[T](list: List[T]): Int = list.foldRight(0) {
    (_, right) => right + 1
  }

  def first[T](list: List[T]): T = list.foldRight(list.head) {
    (left, _) => left
  }

  def concatenate(list: List[String]): String = list.foldRight("") {
    (left, right) => s"${left + right}"
  }

  def contains[T](list: List[T], value: T): Boolean = list.foldRight(false) {
    (left, right) => right || left == value
  }

  override def main(args: Array[String]): Unit = {

    val intList: List[Int] = List(1, 2, 3, 4, 5, 6)
    val stringList: List[String] = List("Joe", "Blogs")

    println(s"The sum of the list is ${sum(intList)}")
    println(s"The length of the list is ${length(intList)}")
    println(s"The first element in the list is ${first(intList)}")
    println(s"The concatenated string is ${concatenate(stringList)}")
    println(s"The intList contains 4 ${contains(intList, 4)} but does not contain 10 ${contains(intList, 10)}")
  }
}
