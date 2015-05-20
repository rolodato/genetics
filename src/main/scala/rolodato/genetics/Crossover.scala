package rolodato.genetics

trait Crossover {
  def cross(parent1: Gene, parent2: Gene): List[Gene]

  def crossAll(population: List[Gene]): List[Gene] = {
    population match {
      case Nil => Nil
      case List(x) => List(x)
      case x :: y :: is => cross(x, y) ++ crossAll(is)
    }
  }
}
