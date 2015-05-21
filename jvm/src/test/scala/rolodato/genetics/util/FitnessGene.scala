package rolodato.genetics.util

import rolodato.genetics.Gene

class FitnessGene(val fitness: Double) extends Gene {

  val string: List[Int] = List(1)

  def copy(newString: List[Int]): Gene = this
}
