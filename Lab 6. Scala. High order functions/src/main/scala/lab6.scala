package main.scala

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
  def isNeedToAdd(c: Array[Int], i: Int): Array[Int] = {
    if (c.contains(i))
      c
    else
      c :+ i
  }

  def deleteRepeated(p: ((Array[Int], Int) => Array[Int])): Array[Int] => Array[Int] = {
    def help(c: Array[Int]): Array[Int] = {
      c.foldLeft(Array[Int]())(p)
    }

    help
  }

  /**
    * Count number of sublists in list
    *
    * @param l    Requred list
    * @param subl Requred sublist
    * @tparam A Requred type
    * @return Number of entries
    */
  def entries[A](l: List[A], subl: List[A]): Int = {
    if (subl.isEmpty || l.isEmpty || l.length < subl.length)
      0
    else {
      (0 to (l.length - subl.length)).foldLeft(0)((res, i) => {
        if (l.slice(i, i + subl.length) == subl)
          res + 1
        else
          res
      })
    }
  }
}
