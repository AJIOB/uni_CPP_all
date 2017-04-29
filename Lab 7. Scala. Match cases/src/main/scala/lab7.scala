package main.scala

/**
  * Created by AJIOB on 18.04.2017.
  *
  * @author AJIOB
  */
object lab7 {
  /**
    * Calculating multiplication of numbers that before zero & sum of elements that above zero
    *
    * @param l List to operation
    * @return pair (mul, sum), where mul is multiplication, and sum is sum
    */
  def mulSum(l: List[Int]): (Int, Int) = {
    l.foldLeft((1, 0))((pair, elem) => {
      val (mul, sum) = pair
      elem match {
        case 0 => pair
        case x if x > 0 => (mul, sum + x)
        case x => (mul * x, sum)
      }
    })
  }

  /**
    * Function that gets number of stars for equilateral triangle and it by List of strings
    *
    * @param n Number of triangle
    * @return Number of required '*' & list of strings to show it
    */
  def triangles(n: Int):(Int, List[String]) = {
    def help(n:Int, i:Int, ss:List[String]):List[String] = {
      if (n == 0)
        ss
      else {
        val s = " " * i + "* " * n
        help(n - 1, i + 1, s :: ss)
      }
    }

    (n*(n+1)/2, help(n, 0, Nil))
  }
}
