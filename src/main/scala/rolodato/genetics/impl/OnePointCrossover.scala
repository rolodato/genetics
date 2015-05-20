package rolodato.genetics.impl

import rolodato.genetics.{Crossover, Gene}

import scala.language.postfixOps

trait OnePointCrossover extends Crossover {

  def crossoverPoint: Int

  def cross(parent1: Gene, parent2: Gene): List[Gene] = {
    require(parent1.length == parent2.length, "gene lengths must be equal")
    val xop: Int = crossoverPoint
    require(0 <= xop && xop <= parent1.length, "xover point must be valid")
    val child1 = ((parent1 string) take xop) ++ ((parent2 string) drop xop)
    val child2 = ((parent2 string) take xop) ++ ((parent1 string) drop xop)
    List(parent1.copy(child1), parent2.copy(child2))
  }

}

object OnePointCrossover {
  def apply(xop: Int) = new OnePointCrossover {
    def crossoverPoint: Int = xop
  }
}
