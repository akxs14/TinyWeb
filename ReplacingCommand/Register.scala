class CashRegister(var total:Int) {
  def addCash(toAdd: Int) {
    total += toAdd
  }

  def makePurchase(register: CashRegister, amount: Int) = {
    () => {
      println("Purchase in amount: " + amount)
      register.addCash(amount)
    }
  }

  var purchases: Vector[() => Unit] = Vector()

  def executePurchase(purchase: () => Unit) = {
    purchases = purchases :+ purchase
    purchase()
  }

 def main(args: Array[String]) {
    val register = new CashRegister(0)
    val purchaseOne = makePurchase(register, 100)
    val purchaseTwo = makePurchase(register, 50)

    executePurchase(purchaseOne)
    executePurchase(purchaseTwo)
    println(register.total)
  }
}
