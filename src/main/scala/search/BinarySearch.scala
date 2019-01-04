package search

import scala.annotation.tailrec

object BinarySearch extends App {

  override def main(args: Array[String]): Unit = {

    var isRunning: Boolean = true
    val sortedList: List[Double] = List(0.0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100)

    while(isRunning) {

      println("\n*********** Binary Search ***********")
      println("\nThe collection => [0.0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100]")

      println("\nChoose binary search algorithm function (1/2) :" +
        "\n1: iterative" +
        "\n2: recursive")

      val searchFunction = try {
        scala.io.StdIn.readLine()
      } catch {
        case t: Throwable => println("Unexpected input type, defaulting to 1..."); "1"
      }

      print("\nEnter a target value (99 to terminate program): ")

      val target = try {
        scala.io.StdIn.readDouble()
      } catch {
        case t: Throwable => println("Unexpected input type, defaulting to zero..."); 0.0
      }

      searchFunction match {
        case "1" =>  println(s"The target is position ${iterativeBinarySearch(target, sortedList).getOrElse("'NOT KNOWN'")} in the sorted list.")
        case "2" =>  println(s"The target is position ${recursiveBinarySearch(target, sortedList).getOrElse("'NOT KNOWN'")} in the sorted list.")
        case _ => println("The chosen search algorithm function has not been implemented yet...")
      }

      if(target == 99) {
        isRunning = false
      }
    }
  }

  def recursiveBinarySearch(target: Double,
                            sortedList: List[Double]): Option[Int] = {

    @tailrec
    def recursion(start: Int,
                  end: Int): Option[Int] = (start + end) / 2 match {

      case _ if end < start => None
      case mid if sortedList(mid) < target => recursion(mid + 1, end)
      case mid if sortedList(mid) > target => recursion(start, mid - 1)
      case mid => Some(mid)
    }

    recursion(0, sortedList.size - 1)
  }

  def iterativeBinarySearch(target: Double,
                            sortedList: List[Double]): Option[Int] = {

    /* Keep track of the start and end off the list */
    var start = 0
    var end = sortedList.size - 1

    /* Loop over the list while start is less than or equal to end */
    while(start <= end) {

      /* calculate the middle of the list */
      var mid = (start + end) / 2

      /*  If the value in the middle of the list is less than
       *  the target, shift the start to the middle plus one space.
       */
      if(sortedList(mid) < target)
        start = mid + 1

      /*  If the value in the middle of the list is greater than
       *  the target, shift the end to the middle minus one space.
       */
      else if(sortedList(mid) > target)
        end = mid - 1

      /*  If the value in the middle of the list is equal to the
       *  target, then the position of the target has been found.
       */
      else if(sortedList(mid) == target)
        return Some(mid)
    }

    /* Else the target is not in present in the list */
    return None
  }
}