package search

import utils.{Common, MetricsUtility}

import scala.annotation.tailrec

/**
  * Binary search is described as O(log N). The iterative halving of data
  * sets described in the binary search example produces a growth curve
  * that peaks at the beginning and slowly flattens out as the size of
  * the data sets increase e.g. an input data set containing 10 items
  * takes one second to complete, a data set containing 100 items takes
  * two seconds, and a data set containing 1000 items will take three
  * seconds. Doubling the size of the input data set has little effect
  * on its growth as after a single iteration of the algorithm the data
  * set will be halved and therefore on a par with an input data set half
  * the size. This makes algorithms like binary search extremely efficient
  * when dealing with large data sets..
  */
object BinarySearchScala extends App with Common with MetricsUtility {

  override def main(args: Array[String]): Unit = {

    /**  Print the app title and collection metrics */
    println("\n*********** Binary Search ***********")
    println(s"\nThe collection is ${sortedList.size} elements large => \n")
    sortedList.foreach(println(_))

    /**
     *  While the app is running, execute user prompts.
     */
    while(isRunning) {

      /**
       *  Display title and collection metrics to user
       *  inside of running loop.
       */
      println("\n*********** Binary Search ***********")
      println(s"\nThe collection is ${sortedList.size} elements large => \n")

      /**
       *  Prompt the user to choose a binary search
       *  algorithm.
       */
      println("\nChoose binary search algorithm function (1/2) :" +
        "\n1: iterative" +
        "\n2: recursive")

      /**
       *  Read user response with exception handling.
       */
      val searchFunction = try {
        scala.io.StdIn.readLine()
      } catch {
        case t: Throwable => println("Unexpected input type, defaulting to 1..."); "1"
      }

      /**
       *  Prompt the user to enter a target to search
       *  for in the collection.
       */
      print("\nEnter a target value (99 to terminate program): ")

      /**
       *  Read the users response with exception handling.
       */
      val target = try {
        scala.io.StdIn.readDouble()
      } catch {
        case t: Throwable => println("Unexpected input type, defaulting to zero..."); 0.0
      }

      /**
       *  Pattern match the users search function response and
       *  decide which binary search function to call on
       *  the collection.
       */
      searchFunction match {
        case "1" => {
          val beforeIterativeBinarySearchStartTime: Long = System.currentTimeMillis()

          println(s"The target is position ${iterativeBinarySearch(target, sortedList).getOrElse("NOT KNOWN")} in the sorted list.")

          printComputationPerformanceInMillis(beforeIterativeBinarySearchStartTime)
        }
        case "2" => {
          val beforeRecursiveBinarySearchStartTime: Long = System.currentTimeMillis()

          println(s"The target is position ${recursiveBinarySearch(target, sortedList).getOrElse("NOT KNOWN")} in the sorted list.")

          printComputationPerformanceInMillis(beforeRecursiveBinarySearchStartTime)
        }
        case _ => println("The chosen search algorithm function has not been implemented yet...")
      }

      /** If the user has responded with 99, terminate the application. */
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

    /** Keep track of the start and end off the list */
    var start = 0
    var end = sortedList.size - 1

    /** Loop over the list while start is less than or equal to end */
    while(start <= end) {

      /** calculate the middle of the list */
      var mid = (start + end) / 2

      /**
       *  If the value in the middle of the list is less than
       *  the target, shift the start to the middle plus one space.
       */
      if(sortedList(mid) < target)
        start = mid + 1

      /**
       *  If the value in the middle of the list is greater than
       *  the target, shift the end to the middle minus one space.
       */
      else if(sortedList(mid) > target)
        end = mid - 1

      /**
       *  If the value in the middle of the list is equal to the
       *  target, then the position of the target has been found.
       */
      else if(sortedList(mid) == target)
        return Some(mid)
    }

    /** Else the target is not in present in the list */
    return None
  }
}