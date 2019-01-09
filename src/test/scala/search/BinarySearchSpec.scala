package search

import core.UnitSpec

class Setup {

  val binarySearch = BinarySearchScala
  val sortedList: List[Double] = List(0.0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100)
}

class BinarySearchSpec extends UnitSpec {

  "iterativeBinarySearch" should
    "yield the position of a given target in a sorted collection" in new Setup {

      val actualResult = binarySearch.iterativeBinarySearch(80, sortedList)
      val expectedResult = Some(8)

      actualResult shouldBe expectedResult
    }

  "iterativeBinarySearch" should
    "yield None if the given target is not in a sorted collection" in new Setup {

      val actualResult = binarySearch.iterativeBinarySearch(101, sortedList)
      val expectedResult = None

      actualResult shouldBe expectedResult
   }

  "recursiveBinarySearch" should
    "yield the position of a given target in a sorted collection" in new Setup {

      val actualResult = binarySearch.recursiveBinarySearch(80, sortedList)
      val expectedResult = Some(8)

      actualResult shouldBe expectedResult
    }

  "recursiveBinarySearch" should
    "yield None if the given target is not in a sorted collection" in new Setup {

      val actualResult = binarySearch.recursiveBinarySearch(101, sortedList)
      val expectedResult = None

      actualResult shouldBe expectedResult
    }
}
