package rolodato.genetics.impl

import rolodato.genetics.{StringGene, UnitSpec}

class IntegerMutationSuite extends UnitSpec {
  test("integer mutation sanity check") {
    val gene = new StringGene(List(2))
    val mutated = IntegerMutation(0.5).mutate(gene).string
    assert(mutated === List(1) || mutated === List(3))
  }
}
