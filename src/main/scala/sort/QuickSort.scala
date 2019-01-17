package sort

// Best case O(n log n)
// Wort case O(n2
// Average case O(n log n)
object QuickSort extends App {

  override def main(args: Array[String]): Unit = {

    val r = scala.util.Random
    val randomArray = (for (i <- 1 to 100) yield r.nextInt(10000)).toArray

    println("=== BEFORE SORT ===")
    printRam
    Thread.sleep(500)

    val sortedArray = sort(randomArray.toList)

    println("=== AFTER SORT ===")
    Thread.sleep(500)
    printRam

    println("=== AFTER GC ===")
    System.gc
    Thread.sleep(500)
    printRam


    println("=== PRINT SORTED ARRAY ===")
    sortedArray.map(println(_))

  }

  def quickSort(array: Array[Int]): Array[Int] = {
    if (array.length < 2) array
    else {
      val pivot = array(array.length / 2)

      quickSort(array filter (pivot >)) ++ (array filter (pivot ==)) ++
        quickSort(array filter (pivot <))
    }
  }

  def sort(li: List[Int]): List[Int] = {

    if (li.size < 2) li
    else {
      val pivot = li.head

      val (left, right) = li.partition(_ < pivot)

      sort(left) ::: pivot :: sort(right.tail)
    }
  }

  /**
    * freeMemory  - the amount of free memory in the JVM (an approximation to the total amount of memory currently available for future allocated objects, measured in bytes)
    * totalMemory - the total amount of memory in the JVM
    * maxMemory   - the maximum amount of memory the JVM will attempt to use
    */
  def printRam {
    println("")
    val mb = 1024*1024
    val runtime = Runtime.getRuntime
    println("** Used Memory:  " + (runtime.totalMemory - runtime.freeMemory) / mb + " MB")
    println("** Free Memory:  " + runtime.freeMemory / mb + " MB")
    println("** Total Memory: " + runtime.totalMemory / mb + " MB")
    println("** Max Memory:   " + runtime.maxMemory / mb + " MB")
  }
}
