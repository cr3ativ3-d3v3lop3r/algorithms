package mathematics

object Factorial extends App {

  def factorial(n: Int): Int = if(n < 2) 1 else n * factorial(n - 1)

  override def main(args: Array[String]): Unit = {

    println(s"Factorial of 5 is => ${factorial(5)}")
  }
}
