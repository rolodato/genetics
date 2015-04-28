package rolodato.genetics

import scala.language.postfixOps

trait Individual {
  def fitness: Double
  def string: List[Int]
  def length: Int = string length
  def copy(newString: List[Int]): Individual = new Individual {
    def fitness: Double = Individual.this.fitness
    def string: List[Int] = newString
  }
  override def toString = string toString
  override def equals(other: Any) = {
    other match {
      case that: Individual => string == that.string && fitness == that.fitness
      case _ => false
    }
  }
}

object Individual {
  def apply(stringInts: Int*) = new Individual {
    override def string = stringInts toList
    override def fitness = 1
  }
}
