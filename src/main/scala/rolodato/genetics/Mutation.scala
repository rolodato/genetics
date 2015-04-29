package rolodato.genetics

trait Mutation {
  def mutationProbability: Double
  def mutate(i: Individual): Individual
}
