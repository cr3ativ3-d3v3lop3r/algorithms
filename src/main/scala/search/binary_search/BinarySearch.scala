package search.binary_search

object BinarySearch extends App {

  override def main(args: Array[String]): Unit = {

    val sortedList = List(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100)

    println(s"The target is position ${basicSearch(101, sortedList).getOrElse("NOT KNOWN")} in the sorted list.")
  }

  private def basicSearch(target: Int, sortedList: List[Int]): Option[Int] = {

    var start = 0
    var end = sortedList.size

    while(start <= end) {
      var mid = (start + end) / 2

      // move the start to the middle +1 space because middle of the sorted list is less than the target.
      if(sortedList(mid) < target) {
        start = (mid + 1)
      }
      // move the end to the middle -1 space because the middle of the sorted list is greater than the target.
      else if(sortedList(mid) > target) {
        end = (mid - 1)
      }
      else {
        return Some(mid) // target is the middle
      }
    }

    return None // target not found
  }
}
