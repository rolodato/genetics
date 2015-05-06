package rolodato.genetics

import scala.language.postfixOps

trait Individual[T] {
  def fitness: Double
  def string: List[T]
  def length: Int = string length
  def copy(newString: List[T]): Individual[T] = new Individual[T] {
    def fitness: Double = Individual.this.fitness
    def string: List[T] = newString
  }
  override def toString = string toString
  override def equals(other: Any) = {
    other match {
      case that: Individual[T] => string == that.string && fitness == that.fitness
      case _ => false
    }
  }
}
