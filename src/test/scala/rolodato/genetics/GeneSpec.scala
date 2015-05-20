package rolodato.genetics

class GeneSpec extends UnitSpec {
  test("result of Gene.copy doesn't inherit parent's fitness") {
    val parent = new StringGene(List(0))
    val child = parent.copy(List(0, 0))
    assert(child.fitness === 2.0)
  }
}
