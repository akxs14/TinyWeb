package newton

object progfun {
  def abs(x: Double) = if(x < 0) -x else x  //> abs: (x: Double)Double

  def sqrtIter(guess:Double, x:Double):Double =
    if(isGoodEnough(guess,x)) guess
    else sqrtIter(improve(guess,x),x) //> sqrtIter: (guess: Double, x: Double)Double
    
  def isGoodEnough(guess: Double, x: Double) =
    abs(guess * guess - x) / x < 0.0001
                                                  //> isGoodEnough: (guess: Double, x: Double)Boolean
  
  def improve(guess: Double, x: Double): Double =
    (guess + x / guess) / 2           //> improve: (guess: Double, x: Double)Double
    
  def sqrt(x: Double) = sqrtIter(1.0, x)    //> sqrt: (x: Double)Double

  sqrt(2)                                   //> res0: Double = 1.4142156862745097
  sqrt(4)                                   //> res1: Double = 2.0000000929222947
  sqrt(1e-6)                                //> res2: Double = 0.0010000001533016628
  sqrt(1e20)                                //> res3: Double = 1.0000021484861237E10
  sqrt(1e-20)                               //> res4: Double = 1.0000021484861236E-10
  sqrt(0.001)                               //> res5: Double = 0.03162278245070105
  sqrt(1e60)                                //> res6: Double = 1.0000000031080746E30
}