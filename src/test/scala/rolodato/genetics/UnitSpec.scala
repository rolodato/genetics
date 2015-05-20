package rolodato.genetics

import org.scalactic.{Equivalence, TolerantNumerics, TypeCheckedTripleEquals}
import org.scalatest.FunSuite

import scala.language.postfixOps

abstract class UnitSpec extends FunSuite with TypeCheckedTripleEquals {
  implicit val doubleEq = TolerantNumerics.tolerantDoubleEquality(0.001)

  implicit val listEq = new Equivalence[List[Double]] {
    override def areEquivalent(a: List[Double], b: List[Double]): Boolean = {
      (a, b) match {
        case (Nil, Nil) => true
        case (x :: xs, y :: ys) => x === y && areEquivalent(xs, ys)
        case _ => false
      }
    }
  }

  def individual(s: Int*): Gene = new StringGene(s toList)

  def individual(fit: Double): Gene = new FitnessGene(fit)
}
