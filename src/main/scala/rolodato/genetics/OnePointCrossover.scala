package rolodato.genetics

import scala.language.postfixOps
import scala.util.Random

object OnePointCrossover {
  def cross[T](i1: Individual[T], i2: Individual[T], xop: Int = Random.nextInt()): List[Individual[T]] = {
    assert(i1.length == i2.length, "individuals must have equal length strings")
    val child1 = ((i1 string) take xop) ++ ((i2 string) drop xop)
    val child2 = ((i2 string) take xop) ++ ((i1 string) drop xop)
    List(i1.copy(child1), i2.copy(child2))
  }


}
