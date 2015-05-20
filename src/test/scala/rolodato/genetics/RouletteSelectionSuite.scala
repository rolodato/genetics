package rolodato.genetics

import rolodato.genetics.RouletteSelection._

class RouletteSelectionSuite extends UnitSpec {

  val fitness = List(61.0, 11.0, 33.0, 25.0, 44.0, 15.0, 17.0)
  val normalized = normalize(fitness)
  val population = fitness map individual

  test("sample roulette with fixed r value is chosen correctly") {
    assert(RouletteSelection(0.5).select(population).fitness === 33.0)
  }

  test("accumulated normalized fitnesses is calculated correctly") {
    val expected = List(0.2961, 0.3495, 0.5097, 0.6311, 0.8447, 0.9175, 1.0)
    val accFit = accumulatedFitness(normalized)
    assert(expected === accFit)
  }

  test("normalized fitness is calculated correctly") {
    val expected = List(0.2961, 0.0534, 0.1602, 0.1214, 0.2136, 0.0728, 0.0825)
    assert(expected === normalized)
  }

  // TODO Generate random test cases
  test("sum of normalized fitnesses is 1") {
    assert(1.0 === normalized.sum)
  }

  test("roulette selection picks the best individual") {
    val fitness = List(100.0, 0.0, 0.0)
    val population = fitness map individual
    assert(RouletteSelection().selectPopulation(population, 2).length === 2)
    assert(RouletteSelection().selectPopulation(population, 1).head.fitness === 100.0)
  }
}
