package rolodato.genetics.impl

import rolodato.genetics.{Gene, Mutation}

import scala.language.postfixOps
import scala.util.Random

object BitStringMutation extends Mutation {
  def apply(i: Gene): Gene = this.mutate(i)

  def mutate(indiv: Gene): Gene = {
    val pos = Random.nextInt(indiv length)
    indiv copy indiv.string.updated(pos, flip(indiv string pos))
  }

  def flip(bit: Int): Int = if (bit == 0) 1 else 0
}
