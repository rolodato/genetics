package rolodato.genetics

import scala.util.Random

trait Crossover {
  /**
   * Applies a crossover algorithm to two parents, and returns a list of
   * children. The amount of generated children depends on each implementation.
   */
  def cross(parent1: Gene, parent2: Gene): Seq[Gene]

  /**
   * Given a population, returns a new one which results from crossing two
   * random genes, removing them and crossing the remaining genes until none
   * remain.
   */
  def crossAll(pop: Seq[Gene]): Seq[Gene] = {
    if (pop.isEmpty) Seq()
    else if (pop.length == 1) Seq(pop.head)
    else {
      val parent1 = pop(Random.nextInt(pop.length))
      val parent2 = pop(Random.nextInt(pop.length))
      val remaining = pop.filter(g => g != parent1 && g != parent2)
      cross(parent1, parent2) ++ crossAll(remaining)
    }
  }
}
