package main.scala

import scala.annotation.tailrec

/**
  * Created by AJIOB on 18.04.2017.
  *
  * @author AJIOB
  */
object lab6 {
  /**
    * Удалить из коллекции все повторяющиеся элементы
    * Delete repeated elements from collection
    */
  def deleteRepeated() : Array[Int] => Array[Int] = {
    def isNeedToAdd(c: Array[Int], i: Int) : Array[Int] = {
      if (c.contains(i))
        c
      else
        c :+ i
    }
    def help(c: Array[Int]) : Array[Int] = {
      c.foldLeft(Array[Int]())(isNeedToAdd)
    }

    help
  }
}
