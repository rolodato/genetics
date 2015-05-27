package rolodato.genetics

trait GeneticResult {
  val finalPopulation: List[Gene]
  def fittest: Gene = finalPopulation.sortBy(-_.fitness).head
  val fitnessEvolution: List[Double]
}
