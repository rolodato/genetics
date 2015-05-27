package rolodato.genetics

import scala.collection.mutable.ListBuffer
import scala.concurrent.{ExecutionContext, Promise, Future}
import scala.language.postfixOps
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

  def run(iterations: Int, initial: List[Gene] = initialPopulation)
         (implicit ec: ExecutionContext): Future[GeneticResult] = {
    def avgFitness(pop: Seq[Gene]): Double = {
      val fitnessList = pop map (_.fitness)
      val length = fitnessList.length
      if (length != 0)
        (fitnessList sum) / length
      else
        0
    }
    Future {
      var population = initial.to[ListBuffer]
      var fitnesses = ListBuffer[Double]()
      val selectionSize = (population.length * selectionPercentage).toInt
      for (i <- 1 to iterations) {
        // Selection
        population = selection.selectPopulation(population, selectionSize).to[ListBuffer]
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
        fitnesses += avgFitness(population)
      }
      new GeneticResult {
        val finalPopulation = population.sortBy(_.fitness).toList
        val fitnessEvolution = fitnesses.toList
      }
    }
  }

}
