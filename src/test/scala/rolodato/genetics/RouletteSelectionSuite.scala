package rolodato.genetics

import org.scalactic.TolerantNumerics
import org.scalatest.FunSuite
import rolodato.genetics.RouletteSelection._

class RouletteSelectionSuite extends FunSuite {

  implicit val doubleEq = TolerantNumerics.tolerantDoubleEquality(0.10)

  // TODO There has to be a better way to do this
  def areEquivalent(a: List[Double], b: List[Double]): Boolean = {
    (a, b) match {
      case (Nil, Nil) => true
      case (x :: xs, y :: ys) => x === y && areEquivalent(xs, ys)
      case _ => false
    }
  }

  val population = List(61.0, 11.0, 33.0, 25.0, 44.0, 15.0, 17.0)

  test("accumulated normalized fitnesses is calculated correctly") {
    val expected = List(0.2961, 0.3495, 0.5097, 0.6311, 0.8447, 0.9175, 1.0)
    val normalized = normalize(population)
    val accFit = accumulatedFitness(normalized)
    assert(areEquivalent(accFit, expected))
  }

  test("normalized fitness is calculated correctly") {
    val expected = List(0.2961, 0.0534, 0.1602, 0.1214, 0.2136, 0.0728, 0.0825)
    val normalized = normalize(population)
    assert(areEquivalent(normalized, expected))
  }

  // TODO Generate random test cases
  test("sum of normalized fitnesses is 1") {
    assert(1.0 === normalize(population).sum)
  }
}
