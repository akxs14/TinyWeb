package lists

import java.util._

object test {
  def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])
                                                  //> singleton: [T](elem: T)lists.Cons[T]
  
  def nth[T](n: Int, xs: List[T]): T =
    if (xs.isEmpty) throw new IndexOutOfBoundsException
    else if(n == 0) xs.head
    else nth(n-1, xs.tail)            //> nth: [T](n: Int, xs: lists.List[T])T

  val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))
                                                  //> list  : lists.Cons[Int] = lists.Cons@61ec56c9
  nth(1,list)                               //> res0: Int = 2
  nth(-1, list)                             //> java.lang.IndexOutOfBoundsException
                                                  //|   at lists.test$$anonfun$main$1.nth$1(lists.test.scala:9)
                                                  //|   at lists.test$$anonfun$main$1.apply$mcV$sp(lists.test.scala:15)
                                                  //|   at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //|   at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //|   at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //|   at lists.test$.main(lists.test.scala:5)
                                                  //|   at lists.test.main(lists.test.scala)
}

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T,val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.head")
}