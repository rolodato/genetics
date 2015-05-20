package rolodato.genetics

class StringGene(val string: List[Int]) extends Gene {
  def fitness: Double = string.length

  def copy(newString: List[Int]): Gene = new StringGene(newString)
}
