/**
  * Created by AJIOB on 17.04.2017.
  *
  * @author AJIOB
  */

package test.scala

import main.scala._
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class tests extends FunSuite {
  test("empty") {
    assert(lab7.mulSum(List[Int]()) == (1, 0))
  }
  test("one element") {
    assert(lab7.mulSum(List[Int](3)) == (1, 3))
  }
  test("only > 0") {
    assert(lab7.mulSum(List[Int](3, 4, 5)) == (1, 12))
  }
  test("only < 0") {
    assert(lab7.mulSum(List[Int](-3, -4, -5)) == (-60, 0))
  }

  test("first triangle") {
    assert(lab7.triangles(1)._1 == 1)
  }

  test("third triangle") {
    assert(lab7.triangles(3)._1 == 6)
  }

  test("forth triangle") {
    assert(lab7.triangles(4)._1 == 10)
  }
}
