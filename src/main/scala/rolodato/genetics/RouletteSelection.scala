package rolodato.genetics

import scala.collection.mutable.ArrayBuffer
import scala.language.postfixOps
import scala.util.Random

object RouletteSelection {
  def select[T](pop: List[Individual[T]], r: Double = Random.nextDouble()): Individual[T] = {
    assert(pop.nonEmpty, "can't select from an empty population")
    val fits = accumulatedFitness(normalize(pop map (_.fitness)))
    (pop zip fits find (_._2 >= r)) match {
      case Some((ind, fit)) => ind
      // If fitnesses can't be normalized, return the first element
      case None => pop.head
    }
  }

  def selectPopulation[T](pop: List[Individual[T]], amount: Int): List[Individual[T]] = {
    assert(amount <= pop.length, "can't select more individuals than members")
    var acc = ArrayBuffer[Individual[T]]()
    val popCopy = pop.toBuffer
    while (acc.length < amount) {
      val selected = select(popCopy.toList)
      popCopy -= selected
      acc += selected
    }
    acc.toList
  }

  def accumulatedFitness(fits: List[Double]): List[Double] = {
    (fits zipWithIndex) map { case (fit, i) =>
      // Own fitness value + fitness values of predecessors
      fit + (fits take i sum)
    }
  }

  def normalize(fitnesses: List[Double]): List[Double] = {
    val total = fitnesses.sum
    if (total != 0) fitnesses map (_ / total)
    else fitnesses
  }
}
