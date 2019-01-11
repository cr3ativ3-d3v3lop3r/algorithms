package basics

object ReduceRight extends App {

  def sum(list: List[Int]): Int = list.reduceRight {
    (left, right) => left + right
  }

  def product(list: List[Int]): Int = list.reduceRight {
    (left, right) => left * right
  }

  def min(list: List[Int]): Int = list.reduceRight {
    (left, right) => left min right
  }

  def max(list: List[Int]): Int = list.reduceRight {
    (left, right) => left max right
  }

  def largest(list: Vector[String]): String = list.reduceRight {
    (left, right) => if (left.length > right.length) left else right
  }

  def shortest(list: Vector[String]): String = list.reduceRight {
    (left, right) => if (left.length < left.length) left else right
  }

  override def main(args: Array[String]): Unit = {

    val intList: List[Int] = List(1, 2, 2, 3, 4, 5, 6)
    val stringList: Vector[String] = Vector("joe", "blogs", "zebediah")

    println(s"The sum of the list is ${sum(intList)}")
    println(s"The product of the list is ${product(intList)}")
    println(s"The minimum value in the list is ${min(intList)}")
    println(s"The largest string in the string list is ${largest(stringList)}")
    println(s"The shortest string in the string list is ${shortest(stringList)}")
  }
}
