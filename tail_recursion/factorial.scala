package newton

object gcd {

  def gcd(a:Int, b:Int): Int =
    if(b == 0) a else gcd(b, a % b)   //> gcd: (a: Int, b: Int)Int

  gcd(14,21)                                //> res0: Int = 7

  def factorial(n: Int): Int =
    if(n == 0) 1 else n * factorial(n -1)
                                                  //> factorial: (n: Int)Int
  factorial(5)                              //> res1: Int = 120
  factorial(6)                              //> res2: Int = 720
  factorial(7)                              //> res3: Int = 5040

  def factorialTail(n: Int, acc:Int): Int = {
    if(n == 0) acc else factorialTail(n -1, n * acc)
  }                                         //> factorialTail: (n: Int, acc: Int)Int
  factorialTail(5,1)                        //> res4: Int = 120
  factorialTail(6,1)                              //> res5: Int = 720
  factorialTail(7,1)                        //> res6: Int = 5040

  def factorial2(n: Int):Int = {
    def loop(acc:Int, n:Int): Int =
      if(n == 0) acc
      else loop(acc * n, n-1)
    loop(1, n)
  }                                         //> factorial2: (n: Int)Int
  factorial2(5)                             //> res7: Int = 120
  factorial2(6)                             //> res8: Int = 720
  factorial2(7)                             //> res9: Int = 5040
}
