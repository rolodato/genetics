package rolodato.genetics

import scala.language.postfixOps

trait Gene {
  def fitness: Double
  def string: List[Int]
  def length: Int = string length
  def copy(newString: List[Int]): Gene = new Gene {
    def fitness = Gene.this.fitness
    def string = newString
  }
  override def toString = string toString
  override def equals(other: Any) = {
    other match {
      case that: Gene => string == that.string && fitness == that.fitness
      case _ => false
    }
  }
}
