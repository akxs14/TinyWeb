package vehichle

class Vehichle(val id: Int, val year: Int) {
  override def toString() : String = "ID: " + id + " Year: " + year
}

class Car (override val id: Int, override val year: Int, 
  val fuelLevel: Int) extends Vehichle(id, year) {
  override def toString() : String = super.toString() + " Fuel Level: " + fuelLevel
}