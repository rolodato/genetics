package rolodato.genetics

import scala.language.postfixOps
import scala.util.Random

object RouletteSelection {
  def select(pop: List[Individual], r: Double = Random.nextDouble()): Individual = {
    val fits = accumulatedFitness(normalize(pop map (_.fitness)))
    // find returns Option, but this should never fail
    (pop zip fits find (_._2 > r)).get._1
  }

  def accumulatedFitness(fits: List[Double]): List[Double] = {
    (fits zipWithIndex) map { case (fit, i) =>
      // Own fitness value + fitness values of predecessors
      fit + (fits take i sum)
    }
  }

  def normalize(fitnesses: List[Double]): List[Double] = {
    val total = fitnesses.sum
    fitnesses map (_ / total)
  }
}
