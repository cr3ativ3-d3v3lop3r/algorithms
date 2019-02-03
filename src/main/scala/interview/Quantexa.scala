package interview

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

/*
 * Stock price question
 *
 * I want to understand the maximum theoretical profit from
 * trading a particular stock yesterday.
 *
 * Suppose we could access yesterdays stock prices as a list,
 * where:
 *
 * The indices are the time in minutes past trade opening time,
 * which was 9:30am local time.
 *
 * The values are the price in dollars of the stock at that time.
 *
 * So if the stock costs $500 at 10:30am, stock_prices_yesterday[60] == 500.
 *
 * Write an efficient function that takes stock_prices_yesterday and returns
 * the best profit, I could have made from 1 purchase and 1 sale of the stock
 * yesterday.
 *
 * For example:
 *
 * stock_prices_yesterday = [10, 12, 7, 5, 8, 11, 4, 9]
 *
 * get_max_profit(stock_prices_yesterday)
 *
 * # Yields 6 (buying for $5 and selling for $11)
 */
object Quantexa extends App {

  def get_max_profit(prices: List[Int]): Int = {

    val profitArray: ArrayBuffer[Int] = ArrayBuffer[Int]()

    for (i <- 0 until prices.size) {
      for (j <- i + 1 until prices.size) {
        profitArray += prices(j) - prices(i)
      }
    }

    if (!profitArray.isEmpty) {
      profitArray.max
    } else 0
  }

  def get_max_profit_tail_recursive(prices: List[Int]): Int = {

    @tailrec
    def tail_recursion(prices: List[Int], acc: Int = 0, profits: ArrayBuffer[Int] = ArrayBuffer.empty): Int = prices match {
      case Nil => acc
      case _ :: sellIndex if sellIndex == Nil => profits.max
      case buyPrice :: sellIndex => tail_recursion(sellIndex, acc + 1, profits += sellIndex.max - buyPrice)
    }

    tail_recursion(prices)
  }

  override def main(args: Array[String]): Unit = {

    val stockPricesFromYesterday: List[Int] = List(10, 12, 7, 5, 8, 11, 4, 9)

    println(s"The max profit is $$${get_max_profit(stockPricesFromYesterday)}")
    println(s"The max profit with tail recursion is $$${get_max_profit_tail_recursive(stockPricesFromYesterday)}")
  }
}
