package rolodato.genetics

trait GeneticResult {
  val finalPopulation: List[Gene]
  val fittest: Gene
  val fitnessEvolution: List[Double]
}
