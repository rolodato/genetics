package rolodato.genetics.impl

import rolodato.genetics.{Gene, Mutation}

import scala.util.Random

trait IntegerMutation extends Mutation {
  /**
   * Mutates one randomly chosen element of a gene's string. The element is
   * either increased or decreased by the configured percentage.
   */
  def mutate(gene: Gene): Gene = {
    val elem = Random.nextInt(gene.length)
    gene.copy {
      val current = gene.string(elem)
      val sign = {
        if (Random.nextBoolean()) 1
        else -1
      }
      val newValue: Int = (current + sign * current * mutationProportion).toInt
      gene.string.updated(elem, newValue)
    }
  }

  /**
   * The proportion by which to scale the mutated element of the gene's
   * string. Should be a value between 0 and 1.0 inclusive.
   */
  def mutationProportion: Double = Random.nextDouble()
}

object IntegerMutation {
  def apply(proportion: Double) = new IntegerMutation {
    override def mutationProportion: Double = proportion
  }

  def apply() = new IntegerMutation {}
}
