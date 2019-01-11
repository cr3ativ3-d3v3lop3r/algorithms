package basics

object FlatMap extends App {

  def upperCase(list: List[String]): List[Char] = list.flatMap(_.toUpperCase)

  override def main(args: Array[String]): Unit = {

    val stringList01: List[String] = List("joe", "bloggs")
    val stringList02: List[String] = List("ben", "test")

    println(s"The intList transformed with a square function applied is ${upperCase(stringList01)}")
  }
}
