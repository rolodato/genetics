package rolodato.genetics.impl

import rolodato.genetics.UnitSpec

class OnePointCrossoverSuite extends UnitSpec {

  val parent1 = individual(1, 2, 3, 4, 5)
  val parent2 = individual(5, 4, 3, 2, 1)
  val children = OnePointCrossover(2).cross(parent1, parent2)
  val child1 = individual(1, 2, 3, 2, 1)
  val child2 = individual(5, 4, 3, 4, 5)

  test("simple crossover example with explicit xpoint works") {
    assert(children === List(child1, child2))
  }

  test("simple crossover to population") {
    val crossed = OnePointCrossover(2).crossAll(List(parent1, parent2))
    assert(crossed.toSet === Set(child1, child2))
  }
}
