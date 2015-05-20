package rolodato.genetics

import scala.language.postfixOps
import scala.util.Random

trait RouletteSelection extends Selection {
  import RouletteSelection._

  def rand: Double

  def select(pop: List[Gene]): Gene = {
    require(pop.nonEmpty, "can't select from an empty population")
    val fits = accumulatedFitness(normalize(pop map (_.fitness)))
    pop zip fits find (_._2 >= rand) match {
      case Some((ind, fit)) => ind
      case None => pop.head
    }
  }
}

object RouletteSelection {
  def apply(rng: => Double) = new RouletteSelection {
    override def rand: Double = rng
  }

  def apply() = new RouletteSelection {
    override def rand = Random.nextDouble()
  }

  def normalize(fitnesses: List[Double]): List[Double] = {
    val total = fitnesses.sum
    if (total != 0) fitnesses map (_ / total)
    else fitnesses
  }

  def accumulatedFitness(fits: List[Double]): List[Double] = {
    (fits zipWithIndex) map { case (fit, i) =>
      // Own fitness value + fitness values of predecessors
      fit + (fits take i sum)
    }
  }
}
