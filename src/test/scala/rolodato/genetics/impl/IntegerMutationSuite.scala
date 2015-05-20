package rolodato.genetics.impl

import rolodato.genetics.{Gene, UnitSpec}

class IntegerMutationSuite extends UnitSpec {
  test("integer mutation sanity check") {
    val gene = new Gene {
      def string: List[Int] = List(2)
      def fitness: Double = 1.0
    }
    val mutated = IntegerMutation(0.5).mutate(gene).string
    assert(mutated === List(1) || mutated === List(3))
  }
}
