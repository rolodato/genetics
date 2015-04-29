package rolodato.genetics

import scala.language.postfixOps
import scala.util.Random

class BitStringMutation(val mutationProbability: Double) extends Mutation {
  def mutate(indiv: Individual): Individual = {
    if (Random.nextDouble() <= mutationProbability) {
      val pos = Random.nextInt(indiv length)
      indiv copy indiv.string.updated(pos, flip(indiv string pos))
    }
    else indiv
  }

  def flip(bit: Int): Int = if (bit == 0) 1 else 0
}

object BitStringMutation {
  def apply(probability: Double) = new BitStringMutation(probability)
  def apply(i: Individual, p: Double): Individual = apply(p).mutate(i)
}
