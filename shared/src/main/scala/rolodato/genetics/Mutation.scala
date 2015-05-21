package rolodato.genetics

trait Mutation {
  def mutate(gene: Gene): Gene
}
