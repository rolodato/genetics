package rolodato.genetics.impl

import rolodato.genetics.{Gene, Mutation}

import scala.util.Random

trait IntegerMutation extends Mutation {

  def mutationPercentage: Double

  def mutate(gene: Gene): Gene = {
    val elem = Random.nextInt(gene.length)
    gene.copy {
      val current = gene.string(elem)
      val sign = {
        if (Random.nextBoolean()) 1
        else -1
      }
      val newValue: Int = (current + sign * current * mutationPercentage).toInt
      gene.string.updated(elem, newValue)
    }
  }

}

object IntegerMutation {
  def apply(percentage: Double) = new IntegerMutation {
    def mutationPercentage: Double = percentage
  }
}
