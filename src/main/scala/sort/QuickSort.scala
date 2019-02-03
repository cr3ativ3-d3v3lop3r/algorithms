package sort

// Best case O(n log n)
// Wort case O(n2)
// Average case O(n log n)
object QuickSort extends App {

  override def main(args: Array[String]): Unit = {

    val r = scala.util.Random
    val randomList = (for (i <- 1 to 10) yield r.nextInt(10000)).toList

    println("=== BEFORE SORT ===")
    printRam
    Thread.sleep(500)

    println("\n=== PRINT UN-SORTED ARRAY ===")
    println(randomList)

    val sortedArray = quickSort(randomList)

    println("\n=== AFTER SORT ===")
    Thread.sleep(500)
    printRam

    println("=== AFTER GC ===")
    System.gc
    Thread.sleep(500)
    printRam


    println("\n=== PRINT SORTED ARRAY ===")
    println(sortedArray)

  }

  def quickSort(list: List[Int]): List[Int] = list match {
      case li if li.size < 2 => li
      case li => {
        val pivot: Int = li.head

        val (left, right) = li.partition(_ < pivot)

        quickSort(left) ::: pivot :: quickSort(right.tail)
      }
    }

  /**
    * freeMemory  - the amount of free memory in the JVM (an approximation to the total amount of memory currently available for future allocated objects, measured in bytes)
    * totalMemory - the total amount of memory in the JVM
    * maxMemory   - the maximum amount of memory the JVM will attempt to use
    */
  def printRam {
    println("")
    val mb = 1024 * 1024
    val runtime = Runtime.getRuntime
    println("** Used Memory:  " + (runtime.totalMemory - runtime.freeMemory) / mb + " MB")
    println("** Free Memory:  " + runtime.freeMemory / mb + " MB")
    println("** Total Memory: " + runtime.totalMemory / mb + " MB")
    println("** Max Memory:   " + runtime.maxMemory / mb + " MB")
  }
}
