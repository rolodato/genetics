package rolodato.genetics.util

import rolodato.genetics.Gene

class FitnessGene(val fitness: Double) extends Gene {

  def copy(newString: List[Int]): Gene = this

  val string: List[Int] = List(1)
}
