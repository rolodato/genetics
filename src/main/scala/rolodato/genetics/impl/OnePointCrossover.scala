package rolodato.genetics.impl

import rolodato.genetics.{Crossover, Gene}

import scala.language.postfixOps
import scala.math.abs
import scala.util.Random

trait OnePointCrossover extends Crossover {

  /**
   * Given two parents, creates two children by applying a one-point
   * crossover algorithm.
   *
   * Unless overridden, the crossover point is chosen randomly.
   *
   * @return a list containing the resulting two children
   * @see http://en.wikipedia.org/wiki/Crossover_%28genetic_algorithm%29#One-point_crossover
   */
  def cross(parent1: Gene, parent2: Gene): List[Gene] = {
    require(parent1.length == parent2.length, "gene lengths must be equal")
    val xop: Int = abs(crossoverPoint % parent1.length)
    val child1 = ((parent1 string) take xop) ++ ((parent2 string) drop xop)
    val child2 = ((parent2 string) take xop) ++ ((parent1 string) drop xop)
    List(parent1.copy(child1), parent2.copy(child2))
  }

  def crossoverPoint: Int = Random.nextInt()

}

object OnePointCrossover {
  /**
   * Creates a crossover algorithm that always uses the same crossover point.
   * @param xop The crossover point to use. Should be between 0 and the gene
   *            string length, exclusive. Useful for testing.
   */
  def apply(xop: Int) = new OnePointCrossover {
    override def crossoverPoint: Int = xop
  }
}
