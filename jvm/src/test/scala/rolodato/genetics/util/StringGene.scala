package rolodato.genetics.util

import rolodato.genetics.Gene

class StringGene(val string: List[Int]) extends Gene {
  lazy val fitness: Double = string.length

  def copy(newString: List[Int]): Gene = new StringGene(newString)
}
