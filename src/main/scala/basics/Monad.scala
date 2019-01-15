package basics

object Monad extends App {

  override def main(args: Array[String]): Unit = {

    val someString = Some("hello")
    val someString2 = Some("world")

    val concatenatedMonads = for {
      s <- someString
      s2 <- someString2
    } yield s + ", " + s2

    val concatenatedMonadsWithFMap = someString.flatMap { s =>
      someString2.map { s2 =>
        s + ", " + s2
      }
    }

    val intList = Some(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

    intList.map { x => println(x) }

    println(s"My concatenated monads are $concatenatedMonads")
    println(s"My concatenated monads with flatMap and map are $concatenatedMonadsWithFMap")
  }
}

trait Monad[A] {

  def map[B](f: (A) => B): Monad[B]

  def flatMap[B](f: (A) => Monad[B]): Monad[B]
}

case class Some[A](value: A) extends Monad[A] {

  override def map[B](f: (A) => B): Monad[B] = Some(f(value))

  override def flatMap[B](f: (A) => Monad[B]): Monad[B] = f(value)

  override def toString: String = value.toString
}