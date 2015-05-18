package rolodato.genetics

class OnePointCrossoverSuite extends UnitSpec {
  test("simple crossover example with explicit xpoint works") {
    val parent1 = individual(1, 2, 3, 4, 5)
    val parent2 = individual(5, 4, 3, 2, 1)
    val children = OnePointCrossover.cross(parent1, parent2, 2)
    val child1 = individual(1, 2, 3, 2, 1)
    val child2 = individual(5, 4, 3, 4, 5)
    assert(children === List(child1, child2))
  }
}
