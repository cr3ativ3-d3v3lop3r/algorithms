package utils

/**
  * Trait to be mixed in to provide performance metrics.
  */
trait MetricsUtility {

  def printComputationPerformanceInMillis(startTime: Long): Unit = {

    val elapsedTime: Long = System.currentTimeMillis() - startTime

    println(s"Operation was computed in $elapsedTime millis elapsed time...")
  }
}
