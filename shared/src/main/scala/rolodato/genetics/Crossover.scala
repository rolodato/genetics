package rolodato.genetics

trait Crossover {
  /**
   * Applies a crossover algorithm to two parents, and returns a list of
   * children. The amount of generated children depends on each implementation.
   */
  def cross(parent1: Gene, parent2: Gene): Seq[Gene]

  /**
   * Given a population, returns a new one which results from crossing the
   * first gene with the second, the second with the third, and so on. The
   * total size of the new population depends on how many children are
   * returned by the implemented algorithm.
   */
  def crossAll(pop: Seq[Gene]): Seq[Gene] = {
    if (pop.isEmpty) Seq()
    else if (pop.length == 1) Seq(pop.head)
    else cross(pop(0), pop(1)) ++ crossAll(pop.drop(2))
  }
}
