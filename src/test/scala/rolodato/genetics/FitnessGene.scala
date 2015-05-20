package rolodato.genetics

class FitnessGene(val fitness: Double) extends Gene {

  def copy(newString: List[Int]): Gene = this

  def string: List[Int] = List(1)
}
