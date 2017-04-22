/**
  * Created by AJIOB on 17.04.2017.
  *
  * @author AJIOB
  */

package test.scala

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import main.scala._
import org.junit.runners.Parameterized.Parameter

import scala.collection.immutable.SortedMap

@RunWith(classOf[JUnitRunner])
class tests extends FunSuite {
  test("empty") {
    assert(lab6.deleteRepeated()(Array[Int]()) sameElements Array[Int]())
  }
  test("one element") {
    assert(lab6.deleteRepeated()(Array(1)) sameElements Array(1))
  }
  test("non repeated") {
    assert(lab6.deleteRepeated()(Array(1,4,2,6,3)) sameElements Array(1,4,2,6,3))
  }
  test("repeated") {
    assert(lab6.deleteRepeated()(Array(1,4,2,6,2,3)) sameElements Array(1,4,2,6,3))
  }
  test("many repeated") {
    assert(lab6.deleteRepeated()(Array(1,1,2,4,2,6,5,1,4,3)) sameElements Array(1,2,4,6,5,3))
  }
}
