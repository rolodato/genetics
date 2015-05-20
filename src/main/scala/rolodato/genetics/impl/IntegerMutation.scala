package rolodato.genetics.impl

import rolodato.genetics.{Gene, Mutation}

import scala.util.Random

trait IntegerMutation extends Mutation {

  def mutationPercentage: Double

  def mutate(i: Gene): Gene = {
    val elem = Random.nextInt(i.length)
    i.copy {
      val current = i.string(elem)
      val sign = {
        if (Random.nextBoolean()) 1
        else -1
      }
      val newValue: Int = (current + sign * current * mutationPercentage).toInt
      i.string.updated(elem, newValue)
    }
  }

}

object IntegerMutation {
  def apply(percentage: Double) = new IntegerMutation {
    def mutationPercentage: Double = percentage
  }
}
