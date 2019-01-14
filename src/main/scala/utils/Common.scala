package utils

/**
  * Trait to be mixed in to search implementations.
  */
trait Common {

  /**
    *  Create a program running flag and populate
    *  a large sorted list with random values between
    *  0 to 98.
    */
  var isRunning: Boolean = true
  val sortedList: List[Double] = List.fill(1000000)(math.random() * 98).sortWith(_ < _)
}
