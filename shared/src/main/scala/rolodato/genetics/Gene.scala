package rolodato.genetics

import scala.language.postfixOps

/**
 * An immutable representation of a gene, individual, or chromosome.
 */
trait Gene {
  /**
   * Returns the value of the gene's fitness function.
   */
  def fitness: Double

  val string: List[Int]

  /**
   * Returns the length of the gene's string.
   * Equivalent to `gene.string.length`.
   */
  def length: Int = string length

  /**
   * Creates a gene of the same type, but with a modified string. The created
   * gene should determine its own fitness.
   * @param newString the string of the gene to create
   */
  def copy(newString: List[Int]): Gene

  override def toString = string toString

  /**
   * Simple equality comparison for genes. Note that two genes with the same
   * strings and fitness values may not necessarily be equal.
   * @param other another object to compare with
   * @return `true` if both genes have equal strings and fitness values,
   *         `false` otherwise.
   */
  override def equals(other: Any) = {
    other match {
      case that: Gene => string == that.string && fitness == that.fitness
      case _ => false
    }
  }
}

object Gene {
  val DummyGene = new Gene {
    def copy(newString: List[Int]): Gene = this
    def fitness: Double = Double.NegativeInfinity
    val string: List[Int] = List()
  }
}
