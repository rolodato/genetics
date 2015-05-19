package rolodato.genetics

import scala.language.postfixOps

object OnePointCrossover {
  def cross[T](i1: Individual[T], i2: Individual[T], xop: Int): List[Individual[T]] = {
    assert(i1.length == i2.length, "individuals must have equal length strings")
    val child1 = ((i1 string) take xop) ++ ((i2 string) drop xop)
    val child2 = ((i2 string) take xop) ++ ((i1 string) drop xop)
    List(i1.copy(child1), i2.copy(child2))
  }

  def crossAll[T](pop: List[Individual[T]], xop: Int): List[Individual[T]] = {
    pop match {
      case Nil => Nil
      case List(x) => List(x)
      case x :: y :: is => cross(x, y, xop) ++ crossAll(is, xop)
    }
  }
}
