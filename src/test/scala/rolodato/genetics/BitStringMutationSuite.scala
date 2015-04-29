package rolodato.genetics

import scala.language.postfixOps

class BitStringMutationSuite extends UnitSpec {
  val ind = individual(1, 0, 1, 0)

  def countDifferences[T](xs: List[T], ys: List[T]) = {
    (xs zip ys) count { case (x, y) => x != y }
  }

  test("bit string mutation with probability = 1") {
    val mutated = BitStringMutation(ind, 1.0)
    assert(countDifferences(ind string, mutated string) === 1)
  }

  test("bit string mutation with probability = 0") {
    val mutated = BitStringMutation(ind, 0.0)
    assert(countDifferences(ind string, mutated string) === 0)
  }
}
