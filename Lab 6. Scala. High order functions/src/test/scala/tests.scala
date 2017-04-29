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
    assert(lab6.deleteRepeated(lab6.isNeedToAdd)(Array[Int]()) sameElements Array[Int]())
  }
  test("one element") {
    assert(lab6.deleteRepeated(lab6.isNeedToAdd)(Array(1)) sameElements Array(1))
  }
  test("non repeated") {
    assert(lab6.deleteRepeated(lab6.isNeedToAdd)(Array(1, 4, 2, 6, 3)) sameElements Array(1, 4, 2, 6, 3))
  }
  test("repeated") {
    assert(lab6.deleteRepeated(lab6.isNeedToAdd)(Array(1, 4, 2, 6, 2, 3)) sameElements Array(1, 4, 2, 6, 3))
  }
  test("many repeated") {
    assert(lab6.deleteRepeated(lab6.isNeedToAdd)(Array(1, 1, 2, 4, 2, 6, 5, 1, 4, 3)) sameElements Array(1, 2, 4, 6, 5, 3))
  }


  test("Entries: empty") {
    assert(lab6.entries(Nil, Nil) == 0)
  }
  test("Entries: second is empty") {
    assert(lab6.entries(List(0, 1, 2), Nil) == 0)
  }
  test("Entries: second has one element") {
    assert(lab6.entries(List(0, 1, 2, 1), List(1)) == 2)
  }
  test("Entries: second has two element") {
    assert(lab6.entries(List(0, 1, 2, 1), List(1, 2)) == 1)
  }
  test("Entries: second has many element") {
    assert(lab6.entries(List(0, 1, 2, 1, 1, 2, 1, 0), List(2, 1)) == 2)
  }
  test("Entries: duplicates") {
    assert(lab6.entries(List(2, 1, 2, 1, 2, 1, 2), List(2, 1, 2)) == 3)
  }
}
