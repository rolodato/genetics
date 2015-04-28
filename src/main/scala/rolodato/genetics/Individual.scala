package rolodato.genetics

trait Individual {
  def fitness: Double
}

object Individual {
  // Constant fitness individual for testing
  def apply(fitness: Double) = new Individual {
    override def fitness: Double = fitness
  }
}
