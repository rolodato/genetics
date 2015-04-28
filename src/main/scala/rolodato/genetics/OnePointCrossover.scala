package rolodato.genetics

object OnePointCrossover {
  // TODO Allow passing Random as crossover value
  def cross(i1: Individual, i2: Individual, xop: Int): Set[Individual] = {
    assert(i1.length == i2.length, "individuals must have equal length strings")
    val child1 = ((i1 string) take xop) ++ ((i2 string) drop xop)
    val child2 = ((i2 string) take xop) ++ ((i1 string) drop xop)
    Set(i1.copy(child1), i2.copy(child2))
  }
}
