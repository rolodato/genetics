package rolodato.genetics

trait Crossover {
  def cross(x: Gene, y: Gene): List[Gene]
  def crossAll[T](pop: List[Gene]): List[Gene] = {
    pop match {
      case Nil => Nil
      case List(x) => List(x)
      case x :: y :: is => cross(x, y) ++ crossAll(is)
    }
  }
}
