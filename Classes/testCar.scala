package main

import car.Car

object testCar {
  def main(args: Array[String]) {
    val car = new Car(2009)
    println("Car made in year " + car.year)    
    println("Miles driven " + car.miles)
    println("Drive for 10 miles")
    car.drive(10)
    println("Miles driven " + car.miles)
  }
}