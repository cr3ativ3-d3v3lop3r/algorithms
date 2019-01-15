package basics

import scala.annotation.tailrec

object Lists extends App {

  def prepend[T](list: List[T], elem: T): List[T] = {
    list.+:(elem)
  }

  def append[T](list: List[T], elem: T): List[T] = {
    list.:+(elem)
  }

  def mergeList[T](list: List[T], list2: List[T]): List[T] = {
    list.:::(list2)
  }

  def listToString(list: List[String]): String = list match {
    case Nil => ""
    case elem :: theRestOfTheList => elem + " " + listToString(theRestOfTheList)
  }

  def sum(list: List[Int]): Int = list match {
    case Nil => 0
    case elem :: theRestOfTheList => elem + sum(theRestOfTheList)
  }

  def sumTailRecursive(list: List[Int]): Int = {

    @tailrec
    def recursion(list: List[Int], acc: Int): Int = list match {
      case Nil => acc
      case elem :: theRestOfTheList => recursion(theRestOfTheList, acc + elem)
    }

    recursion(list, 0)
  }

  override def main(args: Array[String]): Unit = {

    val list: List[Int] = List.tabulate(10)(x => x * 1)
    val list2: List[Int] = List.tabulate(10)(x => x * 3)
    val list3: List[Int] = List.tabulate(10)(x => x)

    val stringList = List("Apples").::("Bananas").::("Oranges")

    println(s"Prepend an item to a list ${prepend(list, 500)}")
    println(s"Append an item to a list ${append(list, 500)}")
    println(s"Two lists merged ${mergeList(list, list2)}")
    println(s"List to string yields ${listToString(stringList)}")
    println(s"The sum of the list3 (${list3}) is ${sum(list3)}")
    println(s"The sum of the list3 (${list3}) with tailRecursion optimization is ${sumTailRecursive(list3)}")
  }
}
