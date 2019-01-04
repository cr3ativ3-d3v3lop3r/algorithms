package search

import utils.MetricsUtility

object LinearSearch extends App with CommonSearch with MetricsUtility {

  override def main(args: Array[String]): Unit = {

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

      isRunning = false
    }

  }
}
