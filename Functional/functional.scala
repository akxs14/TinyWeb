case class Person(firstName: String, lastName: String)

object Test {
  def main(args: Array[String]) {
    val p1 = Person("Michael", "Pipa")
    val p2 = Person("AMichael2", "Pipa")
    val p3 = Person("Michae(l3", "Pipa")
    
    val people = Vector(p3, p2, p1)
    println(people)
    people.sortWith((p1,p2) => p1.firstName < p2.firstName)
    println(people)
  }
}
