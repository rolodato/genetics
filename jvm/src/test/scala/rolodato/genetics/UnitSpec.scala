package rolodato.genetics

import org.scalactic.{Equivalence, TolerantNumerics, TypeCheckedTripleEquals}
import org.scalatest.FunSuite
import rolodato.genetics.util.{FitnessGene, StringGene}

import scala.language.postfixOps

abstract class UnitSpec extends FunSuite with TypeCheckedTripleEquals {
  implicit val doubleEq = TolerantNumerics.tolerantDoubleEquality(0.001)

  implicit val listEq = new Equivalence[Seq[Double]] {
    override def areEquivalent(a: Seq[Double], b: Seq[Double]): Boolean = {
      (a.isEmpty && b.isEmpty) ||
        (a.nonEmpty && b.nonEmpty && a.head === b.head && areEquivalent(a.tail, b.tail))
    }
  }

  def individual(s: Int*): Gene = new StringGene(s toList)

  def individual(fit: Double): Gene = new FitnessGene(fit)
}
