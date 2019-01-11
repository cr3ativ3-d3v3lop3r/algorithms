package basics

object FoldLeft extends App {


  def sum(list: List[Int]): Int = list.foldLeft(0) {
    (left, right) => left + right
  }

  def sum_02(list: List[Int]): Int = (0 /: list) {
    (left, right) => right + left
  }

  def length[T](list: List[T]): Int = list.foldLeft(0) {
    (left, _) => left + 1
  }

  def length_02[T](list: List[T]): Int = (0 /: list) {
    (left, _) => left + 1
  }

  def first[T](list: List[T]): T = list.foldLeft(list.head) {
    (left, _) => left
  }

  def first_02[T](list: List[T]): T = (list.head /: list) {
    (left, _) => left
  }

  def last[T](list: List[T]): T = list.foldLeft(list.head) {
    (_, right) => right
  }

  def last_02[T](list: List[T]): T = (list.head /: list) {
    (_, right) => right
  }

  def concatenate(list: List[String]): String = list.foldLeft("") {
    (left, right) => s"${left + right}"
  }

  def concatenate_02(list: List[String]): String = ("" /: list) {
    (left, right) => s"${left + right}"
  }

  def contains[T](list: List[T], value: T): Boolean = list.foldLeft(false) {
    (left, right) => left || right == value
  }

  def contains_02[T](list: List[T], value: T): Boolean = (false /: list) {
    (left, right) => left || right == value
  }

  def reverse[T](list: List[T]): List[T] = list.foldLeft(List[T]()) {
    (left, right) => right :: left
  }

  def reverse_02[T](list: List[T]): List[T] = (List[T]() /: list) {
    (left, right) => right :: left
  }

  def removeDuplicates[T](list: List[T]): List[T] = list.foldLeft(List[T]()) {
    (left, right) => if(left.contains(right)) left else right :: left
  }.reverse

  def removeDuplicates_02[T](list: List[T]): List[T] = (List[T]() /: list) {
    (left, right) => if(left.contains(right)) left else right :: left
  }.reverse

  override def main(args: Array[String]): Unit = {

    val intList: List[Int] = List(1, 2, 2, 3, 4, 5, 6)
    val stringList: List[String] = List("Joe", "Blogs")

    val x = (0 to 100)./:(0) {
      (left, right) => left + right
    }

    println(x)

    println(s"The sum of the list is ${sum_02(intList)}")
    println(s"The length of the list is ${length_02(intList)}")
    println(s"The first element in the list is ${first_02(intList)}")
    println(s"The last element in the list is ${last_02(intList)}")
    println(s"The concatenated string is ${concatenate_02(stringList)}")
    println(s"The intList contains 4 ${contains_02(intList, 4)} but does not contain 10 ${contains(intList, 10)}")
    println(s"The reverse of the intList is ${reverse_02(intList)}")
    println(s"The list with duplicates removed is ${removeDuplicates_02(intList)}")
  }
}
