package rolodato.genetics

import scala.collection.mutable.ArrayBuffer
import scala.language.postfixOps

trait Selection {
  protected def rand: Double
  def select(population: List[Gene]): Gene
  def selectPopulation(pop: List[Gene], amount: Int): List[Gene] = {
    require(0 < amount && amount <= pop.length, "invalid selection amount")
    // TODO Make this declarative
    var acc = ArrayBuffer[Gene]()
    val popCopy = pop.toBuffer
    while (acc.length < amount) {
      val selected = select(popCopy.toList)
      popCopy -= selected
      acc += selected
    }
    acc.toList
  }
}
