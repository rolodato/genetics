package rolodato.genetics

class OnePointCrossoverSuite extends UnitSpec {
  test("simple crossover example with explicit xpoint works") {
    val parent1 = Individual(1, 2, 3, 4, 5)
    val parent2 = Individual(5, 4, 3, 2, 1)
    val children = OnePointCrossover.cross(parent1, parent2, 2)
    val child1 = Individual(1, 2, 3, 2, 1)
    val child2 = Individual(5, 4, 3, 4, 5)
    assert(children === Set(child1, child2))
  }
}