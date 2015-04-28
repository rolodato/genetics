package rolodato.genetics

import rolodato.genetics.RouletteSelection._

class RouletteSelectionSuite extends UnitSpec {

  val population = List(61.0, 11.0, 33.0, 25.0, 44.0, 15.0, 17.0)
  val normalized = normalize(population)

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
}
