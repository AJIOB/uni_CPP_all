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
  test("sort tailrec: empty") {
    assert(lab5.sort(Nil)==Nil)
    assert(lab5.sortNoTail(Nil)==Nil)
  }

  test("sort tailrec: 1 element") {
    assert(lab5.sort(List(3))==List(3))
    assert(lab5.sortNoTail(List(3))==List(3))
  }

  test("sort tailrec: 5 elements") {
    assert(lab5.sort(List(5,3,4,1,2))==List(1,2,3,4,5))
    assert(lab5.sortNoTail(List(5,3,4,1,2))==List(1,2,3,4,5))
  }

  test("sort tailrec: with duplicates") {
    assert(lab5.sort(List(5,3,6,1,5,4,1,2))==List(1,1,2,3,4,5,5,6))
    assert(lab5.sortNoTail(List(5,3,6,1,5,4,1,2))==List(1,1,2,3,4,5,5,6))
  }

  test("numEntries: with duplicates") {
    assert(lab5.numEntries(List(1,2,4,3,6,2,4)) == SortedMap(1->1, 2->2, 3->1, 4->2, 6->1));
  }

  test("numEntries: empty") {
    assert(lab5.numEntries(List()) == SortedMap());
  }

  test("numEntries: one element") {
    assert(lab5.numEntries(List(2)) == SortedMap(2->1));
  }
}
