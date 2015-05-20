package rolodato.genetics

trait Mutation {
  def mutate(i: Gene): Gene
}
