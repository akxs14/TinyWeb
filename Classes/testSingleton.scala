package main

import singleton._

object Singleton {
  def main(args: Array[String]) {
    println(Marker.getMarker("blue"))
    println(Marker.getMarker("blue"))
    println(Marker.getMarker("red"))
    println(Marker.getMarker("red"))
    println(Marker.getMarker("yellow"))
    println(Marker.primaryColors)
  }
}