package main.scala

import scala.annotation.tailrec
import scala.collection.immutable.SortedMap

/**
  * Created by AJIOB on 17.04.2017.
  *
  * @author AJIOB
  */
object lab5 {
  /**
    * Реалиовать сортировку списка
    * List sort
    */
  def sort(list: List[Int]): List[Int] = {
    @tailrec
    def helpSort(l: List[Int], reminder: List[Int]): List[Int] = {
      if(reminder.isEmpty)
        l
      else
        helpSort(reminder.filter(_ == reminder.max) ++ l, reminder.filter(_ < reminder.max))
    }

    helpSort(Nil, list)
  }

  /**
    * Реалиовать сортировку списка без хвостовой рекурсии
    * List sort without tail recursion
    */
  def sortNoTail(list: List[Int]): List[Int] = {
    if(list.isEmpty)
      list
    else
      sortNoTail(list.filter(_ < list.max)) ++ list.filter(_ == list.max)
  }

  /**
    * Simpe factorial
    */
  def fact(n: Int): Int = {
    if (n == 0)
      1
    else
      n*fact(n-1)
  }

  /**
    * Write function that get List and return Map:
    *   element will be key
    *   number of entries of key in List will be value
    */
  def numEntries(list: List[Int]): SortedMap[Int, Int] = {
    def help(list: List[Int], map: SortedMap[Int, Int]): SortedMap[Int, Int] = {
      if (list.isEmpty)
        map
      else
        help(list.filter(_ != list.head), map + (list.head -> list.count(_ == list.head)))
    }

    help(list, SortedMap())
  }
}
