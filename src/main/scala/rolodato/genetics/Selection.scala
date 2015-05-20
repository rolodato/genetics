package rolodato.genetics

import scala.collection.mutable.ArrayBuffer
import scala.language.postfixOps

trait Selection {
  protected def rand: Double

  def select(population: List[Gene]): Gene

  /**
   * Given a population, repeatedly applies a selection algorithm to obtain a
   * subset of the original population.
   * @param population the population to select genes from
   * @param amount amount of genes to return in the population subset
   */
  def selectPopulation(population: List[Gene], amount: Int): List[Gene] = {
    require(0 < amount && amount <= population.length, "invalid selection amount")
    // TODO Make this declarative
    var acc = ArrayBuffer[Gene]()
    val popCopy = population.toBuffer
    while (acc.length < amount) {
      val selected = select(popCopy.toList)
      popCopy -= selected
      acc += selected
    }
    acc.toList
  }
}
