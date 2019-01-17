package recursion

import scala.annotation.tailrec

object Recursion extends App {

  // (1) yields a "java.lang.StackOverflowError" with large lists
  def sum(list: List[Int]): Int = list match {
    case Nil => 0
    case head :: tail => head + sum(tail)
  }

  // (2) tail-recursive solution
  def sum2(list: List[Int]): Int = {

    @tailrec
    def tailRec(list: List[Int], acc: Int): Int = {
      list match {
        case Nil => acc
        case head :: tail => tailRec(tail, acc + head)
      }
    }

    tailRec(list, 0)
  }

  // (3) if else
  def sum3(list: List[Int]): Int = {
    if(list.isEmpty) 0
    else list.head + sum3(list.tail)
  }

  // (4) sumWithReduce
  def sumWithReduce(list: List[Int]): Int = list.reduceLeft(_ + _)

  // (5) basic recursive product
  def product(list: List[Int]): Int = list match {
    case Nil => 1
    case head :: tail => head * product(tail)
  }

  // (6) Tail recursive product
  def product2(list: List[Int]): Int = {

    @tailrec
    def tailRec(list: List[Int], acc: Int): Int = {
      list match {
        case Nil => acc
        case head :: tail => tailRec(tail, acc * head)
      }
    }

    tailRec(list, 1)
  }

  // (7) product with reduce
  def productWithReduce(list: List[Int]): Int = list.reduceLeft(_ * _)

  // (8) max with match
  def maxWithMatch(list: List[Int]): Int = {

    @tailrec
    def tailRec(list: List[Int], theMax: Int): Int = {
      list match {
        case Nil => theMax
        case head :: tail =>
          val max = if (head > theMax) head else theMax
          tailRec(tail, max)
      }
    }

    tailRec(list, 0)
  }

  // (9) max with if/else
  def maxWithIfElse(list: List[Int]): Int = {

    @tailrec
    def tailRec(list: List[Int], theMax: Int): Int = {
      if(list.isEmpty)
        theMax
      else {
        val max = if (list.head > theMax) list.head else theMax
        tailRec(list.tail, max)
      }
    }

    tailRec(list, 0)
  }

  // (10) Fibonacci basic recursion
  def fibonacci(first: Int, second: Int): Unit = {

    if (first == 1)
      println(first)

    if(second == 2)
      println(second)

    val next = first + second

    println(next)

    if (next > 1000000)
      System.exit(0)
    else fibonacci(second, next)
  }

  // (11) Fibonacci tail recursive rosettacode.org/wiki/Fibonacci_sequence#Scala
  def fibonacciTailRec(x: Int): Unit = {

    @tailrec
    def tailRecursion(x: Int, first: Int = 0, second: Int = 1): Unit = {

      x match {
        case 0 => println(first)
        case 1 => println(second)
        case _ => {

          println(second)

          tailRecursion(x - 1, second, second + first)
        }
      }
    }

    tailRecursion(x)
  }

  // (12) Basic factorial
  def factorial(n: Int): Int = {
    if (n == 0) 1
    else n * factorial(n - 1)
  }

  // (13) Tail recursive factorial
  def tailRecursiveFactorial(n: Int): Int = {

    @tailrec
    def tailRecursion(acc: Int, n: Int): Int = {
      if (n == 0) acc
      else tailRecursion(n * acc, n - 1)
    }

    tailRecursion(1, n)
  }

  override def main(args: Array[String]): Unit = {

    val list = List.range(1, 10)

    println(s"The list is $list")

    println(s"The basic recursive sum is ${sum(list)}")
    println(s"The tail recursive sum is ${sum2(list)}")
    println(s"The sum with if/else is ${sum3(list)}")
    println(s"The sum with reduceLeft is ${sumWithReduce(list)}")

    println(s"The basic recursive product is ${product(list)}")
    println(s"The tail recursive product is ${product2(list)}")
    println(s"The product with reduce left is ${productWithReduce(list)}")

    println(s"The max with match is ${maxWithMatch(list)}")
    println(s"The max with if/else is ${maxWithIfElse(list)}")

    println(s"The basic fibonacci is ${fibonacci(1, 2)}")
    println(s"The tail recursive fibonacci is ${fibonacciTailRec(10)}")

    println(s"Basic factorial is ${factorial(4)}")
    println(s"The tail recursive factorial is ${tailRecursiveFactorial(4)}")
  }
}
