package bigO

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

trait CommonAttributes {

  var startTime: Long = 0
  var endTime: Long = 0
  var theArray: ArrayBuffer[Int] = ArrayBuffer[Int]()

  def fillTheArray(count: Int): Unit = {
    (0 to count).map( _ => theArray += (math.random() * 98).toInt )
  }
}

object BigONotation extends App with CommonAttributes {

  // O(1)
  def addItemToArray(newItem: Int): Unit = {
    theArray += newItem
  }

  // O(N)
  def linearSearch(value: Int): Unit = {

    var found = false
    var indexsWithValue = ""

    startTime = System.currentTimeMillis()

    (0 to theArray.size - 1).map { i =>

      if(theArray(i) == value) {
        found = true
        indexsWithValue += i + " ";
      }

    }

    println(s"Value has been found: $found at indexes $indexsWithValue")
    endTime = System.currentTimeMillis()
    println(s"Linear search took ${(endTime - startTime)} milliseconds")
  }

  // O(N^2)
  def bubbleSort(list: ArrayBuffer[Int]): Unit = {

    println(s"The unsorted list is ${list.map(x => x)}")

    startTime = System.currentTimeMillis()

    (0 until list.length - 1).map { i =>

      (0 until list.length - 1 - i).map { j =>

        if(list(j) > list(j + 1)) {
          val tmp = list(j)
          list(j) = list(j + 1)
          list(j + 1) = tmp
        }
      }
    }

    endTime = System.currentTimeMillis()
    println(s"Linear search took ${(endTime - startTime)} milliseconds")
    println(s"The sorted list is ${list.map(x => x)}")
  }

  // O(log N)
  def binarySearch(value: Int, list: List[Int]): Option[Int] = {

    @tailrec
    def recursion(start: Int, end: Int): Option[Int] = start + end / 2 match {

      case _ if end < start => None
      case mid if list(mid) == value => Some(mid)
      case mid if list(mid) < value => recursion(mid + 1, end)
      case mid if list(mid) > value => recursion(start, mid - 1)
    }

    recursion(0, list.size - 1)
  }

  // O(n log n)

  override def main(args: Array[String]): Unit = {

    //fillTheArray(200)

    //addItemToArray(10)
    //linearSearch(10)
    //bubbleSort(ArrayBuffer.fill(1000)((math.random() * 98).toInt))
    println(s"The value is at index ${binarySearch(10, List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))}")
  }
}
