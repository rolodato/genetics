package rolodato.genetics

trait Mutation {
  val mutationProbability: Double
  def mutate(i: Individual): Individual
}
