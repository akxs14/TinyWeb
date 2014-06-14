package intsets

object IntSets {
  val t1 = new NonEmpty(3, Empty, Empty)    //> t1  : intsets.NonEmpty = {.3.}
  val t2 = t1 incl 4 incl 6 incl 1          //> t2  : intsets.IntSet = {{.1.}3{.4{.6.}}}
  t2 union t1                               //> res0: intsets.IntSet = {{.1.}3{{.4.}6.}}
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  override def toString = "."
  def union(other: IntSet): IntSet = other
}

class NonEmpty (elem:Int, left:IntSet, right:IntSet) extends IntSet {
  def contains(x:Int): Boolean =
    if(x < elem) left contains x
    else if(x > elem) right contains x
    else true
  
  def incl(x: Int): IntSet =
    if(x < elem) new NonEmpty(elem, left incl x, right)
    else if(x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def toString = "{" + left + elem + right + "}"
  def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem
}

abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2
  def bar = 3
}