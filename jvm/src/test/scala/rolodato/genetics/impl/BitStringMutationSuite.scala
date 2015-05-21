package rolodato.genetics.impl

import rolodato.genetics.UnitSpec

import scala.language.postfixOps

class BitStringMutationSuite extends UnitSpec {
  val ind = individual(1, 0, 1, 0)

  def countDifferences[T](xs: List[T], ys: List[T]) = {
    (xs zip ys) count { case (x, y) => x != y }
  }

  test("bit string mutation changes only one bit") {
    val mutated = BitStringMutation(ind)
    assert(countDifferences(ind string, mutated string) === 1)
  }
}
