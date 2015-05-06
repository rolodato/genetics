package rolodato.genetics

trait Mutation[T] {
  def mutationProbability: Double
  def mutate(i: Individual[T]): Individual[T]
}
