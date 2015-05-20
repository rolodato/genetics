package rolodato.genetics

import scala.util.Random

trait Genetic {

  val populationSize: Int
  val mutation: Mutation
  val mutationProbability: Double
  val crossover: Crossover
  val selection: Selection
  val selectionPercentage: Double
  val rng: Random
  def randomGene(): Gene

  def initialPopulation: List[Gene] = {
    Seq.fill(populationSize)(randomGene()).toList
  }

  def run(iterations: Int): List[Gene] = {
    var population: List[Gene] = initialPopulation
    val selectionSize = (population.length * selectionPercentage).toInt
    for (i <- 1 to iterations) {
      // Selection
      population = selection.selectPopulation(population, selectionSize)
      // Crossover
      while (population.length < populationSize) {
        population ++= crossover.crossAll(population)
      }
      if (population.length > populationSize) {
        population = population.take(populationSize)
      }
      // Mutation
      if (mutationProbability >= rng.nextDouble()) {
        val pos = rng.nextInt(populationSize)
        population = population.updated(pos, mutation.mutate(population(pos)))
      }
    }
    population
  }

}
