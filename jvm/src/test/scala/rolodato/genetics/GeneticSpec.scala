package rolodato.genetics

import rolodato.genetics.impl.{IntegerMutation, OnePointCrossover, RouletteSelection}
import rolodato.genetics.util.FitnessGene

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.util.Random

class GeneticSpec extends UnitSpec {
  def avgFitness(pop: Seq[Gene]): Double = {
    val fitnessList = pop map (_.fitness)
    val length = fitnessList.length
    if (length != 0)
      (fitnessList sum) / length
    else
      0
  }

  object TestGenetic extends Genetic {
    val populationSize: Int = 500
    val mutationProbability: Double = 0.1
    val selection: Selection = RouletteSelection()
    val crossover: Crossover = OnePointCrossover()
    val mutation: Mutation = IntegerMutation()
    val selectionPercentage: Double = 0.2
    val rng: Random = Random
    def randomGene(): Gene = new FitnessGene(rng.nextDouble())
  }


  test("genetic algorithm increases average fitness (flaky)") {
    val initial = TestGenetic.initialPopulation
    val initialFitness = avgFitness(initial)
    val finishedFitness = avgFitness(Await.result(TestGenetic.run(30, initial), 1 minute).finalPopulation)
    assert(finishedFitness > initialFitness)
  }
}
