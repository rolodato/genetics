package rolodato.genetics

import scala.language.postfixOps

trait Individual[+T] {
  def fitness: Double
  def string: List[T]
  def length: Int = string length
  def copy[S >: T](newString: List[S]): Individual[S] = new Individual[S] {
    def fitness: Double = Individual.this.fitness
    def string: List[S] = newString
  }
  override def toString = string toString
  override def equals(other: Any) = {
    other match {
      case that: Individual[T] => string == that.string && fitness == that.fitness
      case _ => false
    }
  }
}
