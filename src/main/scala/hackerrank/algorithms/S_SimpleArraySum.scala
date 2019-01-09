package hackerrank.algorithms

object S_SimpleArraySum extends App {

  def simpleArraySum(array: List[Int]): Int = array.foldLeft(0)(_ + _)

  override def main(args: Array[String]): Unit = {

    println("Enter the integers to fill the array with spaces: ")
    val arrayItems = readLine().split(" ")

    val array = arrayItems.flatMap { e =>
      List(e.trim.toInt)
    }.toList

    print("The array is [")
      array.foreach(print(_))
    print("]\n")

    println(s"The sum of the array is ${simpleArraySum(array)}")
  }
}
