package rolodato.genetics

import scala.language.postfixOps
import scala.util.Random

class BitStringMutation(val mutationProbability: Double) extends Mutation[Int] {
  def mutate(indiv: Individual[Int]): Individual[Int] = {
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
  def apply(i: Individual[Int], p: Double): Individual[Int] = apply(p).mutate(i)
}
