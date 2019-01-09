package search

import utils.MetricsUtility

import scala.annotation.tailrec

object LinearSearchScala extends App with CommonSearch with MetricsUtility {

  override def main(args: Array[String]): Unit = {

    val sortedList: List[Double] = List.fill(10)(math.random() * 98).sortWith(_ < _)

    /**  Print the app title and collection metrics */
    println("\n*********** Linear Search ***********")
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
        *  Prompt the user to choose a linear search
        *  algorithm.
        */
      println("\nChoose linear search algorithm function (1/2) :" +
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
        *  decide which linear search function to call on
        *  the collection.
        */
      searchFunction match {
        case "1" => {
          val beforeIterativeLinearSearchStartTime: Long = System.currentTimeMillis()

          println(s"The target is position ${iterativeLinearSearch(target, sortedList).getOrElse("NOT KNOWN")} in the sorted list.")

          printComputationPerformanceInMillis(beforeIterativeLinearSearchStartTime)
        }
        case "2" => {
          val beforeRecursiveLinearSearchStartTime: Long = System.currentTimeMillis()

          println(s"The target is position ${recursiveLinearSearch(target, sortedList).getOrElse("NOT KNOWN")} in the sorted list.")

          printComputationPerformanceInMillis(beforeRecursiveLinearSearchStartTime)
        }
        case _ => println("The chosen search algorithm function has not been implemented yet...")
      }

      /** If the user has responded with 99, terminate the application. */
      if(target == 99) {
        isRunning = false
      }
    }

  }

  def recursiveLinearSearch(target: Double,
                            list: List[Double]): Option[Int] = {

    @tailrec
    def recursion(list: List[Double], counter: Int): Option[Int] = {

      if (list.isEmpty)
        None
      else if (list(counter) == target)
        return Some(counter)
      else recursion(list, + 1)
    }

    recursion(list, 0)
  }

  def iterativeLinearSearch(target: Double,
                            list: List[Double]): Option[Int] = {

    if (list.isEmpty)
      return None

    for (i <- 0 to list.size - 1) {

      if (list(i) == target)
        return Some(i)
    }

    return None
  }
}
