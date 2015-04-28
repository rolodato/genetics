package rolodato.genetics

import RouletteSelection._

import scala.language.postfixOps
import scala.util.Random

trait RouletteSelection {
  def select(population: List[Individual]): Individual = {
    // TODO How to test this? Generators + proportions of results?
    val fits = normalize(population map (_.fitness))
    // Sort the population in the same order as the normalized fitness values
    val popWithFits = population zip fits sortBy (-_._2)
    // Separate population and fitness values after sorting
    val sortedPop = popWithFits.unzip._1
    val sortedFits = popWithFits.unzip._2
    val accFits = accumulatedFitness(sortedFits)
    // TODO Make random generator configurable to allow reproducible results
    // find returns Option, but this should never fail
    (sortedPop zip accFits find (_._2 > Random.nextDouble)).get._1
  }
}

object RouletteSelection {
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
