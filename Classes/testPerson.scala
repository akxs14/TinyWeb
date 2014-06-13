package main

import person.Person

object testPerson {
  def main(args: Array[String]) {
    val john = new Person("John", "Smith", "Analyst")
    println(john)
    val bill = new Person("Bill", "Walker")
    println(bill)
  }
}
