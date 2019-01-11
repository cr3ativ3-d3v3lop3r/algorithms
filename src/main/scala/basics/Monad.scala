package basics

object Monad extends App {

  override def main(args: Array[String]): Unit = {

    val someValue = CustomSome("hello")

    val chained = for {
      a <- someValue
    } yield a

    println(s"The chained value is ${chained.map(_.toUpperCase)}")
  }
}

trait Monad[A] {

  def map[B](f: (A) => B): Monad[B]

  def flatMap[B](f: (A) => Monad[B]): Monad[B]
}

case class CustomSome[A](value: A) extends Monad[A] {

  override def map[B](f: (A) => B): Monad[B] = CustomSome(f(value))

  override def flatMap[B](f: (A) => Monad[B]): Monad[B] = f(value)
}