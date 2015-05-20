package rolodato.genetics.impl

import rolodato.genetics.{Crossover, Gene}

import scala.language.postfixOps

trait OnePointCrossover extends Crossover {

  def crossoverPoint: Int

  def cross(i1: Gene, i2: Gene): List[Gene] = {
    require(i1.length == i2.length, "gene lengths must be equal")
    val xop: Int = crossoverPoint
    require(0 <= xop && xop <= i1.length, "xover point must be valid")
    val child1 = ((i1 string) take xop) ++ ((i2 string) drop xop)
    val child2 = ((i2 string) take xop) ++ ((i1 string) drop xop)
    List(i1.copy(child1), i2.copy(child2))
  }

}

object OnePointCrossover {
  def apply(xop: Int) = new OnePointCrossover {
    def crossoverPoint: Int = xop
  }
}
