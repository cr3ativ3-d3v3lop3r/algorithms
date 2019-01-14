package sort

import utils.Common

import scala.collection.mutable.ArrayBuffer

object BubbleSort extends App with Common {

  def bubbleSort(list: ArrayBuffer[Int]): Unit = {

    (0 until list.length - 1).map { i =>

      (0 until list.length - 1 - i).map { j =>

        if(list(j) > list(j + 1)) {
          val tmp = list(j)
          list(j) = list(j + 1)
          list(j + 1) = tmp
        }
      }
    }
  }

  override def main(args: Array[String]): Unit = {

    val list: ArrayBuffer[Int] = ArrayBuffer.fill(100)((math.random() * 98).toInt)

    println(s"The unsorted list is ${list.map(x => x)}")

    bubbleSort(list)

    println(s"The sorted list is ${list.map(x => x)}")
  }

}
