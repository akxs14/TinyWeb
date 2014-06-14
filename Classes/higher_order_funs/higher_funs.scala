package newton

object higher_order_funs {
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if(a > b) 0
    else f(a) + sum(f, a + a, b)      //> sum: (f: Int => Int, a: Int, b: Int)Int

  def sumInts(a: Int, b: Int) = sum((x:Int) => x, a, b)
                                                  //> sumInts: (a: Int, b: Int)Int
  def sumCubes(a: Int, b: Int) = sum((x:Int) => x*x*x, a, b)
                                                  //> sumCubes: (a: Int, b: Int)Int
  def sumFactorials(a: Int, b: Int) = sum((x:Int) => if(x == 0) 1 else fact(x-1), a, b)
                                                  //> sumFactorials: (a: Int, b: Int)Int
  
  def fact(x: Int): Int = if (x == 0) 1 else fact(x - 1)
                                                  //> fact: (x: Int)Int
  sumInts(1,2)                                    //> res0: Int = 3
  sumCubes(1,2)                             //> res1: Int = 9
  sumFactorials(1,2)                        //> res2: Int = 2

  def sum2(f: Int => Int)(a:Int, b:Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if(a > b) acc
      else loop(a + 1 , f(a) + acc )
    }
    loop(a , 0)
  }                                         //> sum2: (f: Int => Int)(a: Int, b: Int)Int

  sum2((x:Int) => x)(1,2)                   //> res3: Int = 3
  sum2((x:Int) => x * x * x)(1,2)           //> res4: Int = 9
}