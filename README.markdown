# genetics [![Build Status](https://travis-ci.org/rolodato/genetics.svg?branch=master)](https://travis-ci.org/rolodato/genetics)

Implement genetic algorithms in Scala.
This is only a learning project, not guaranteed to be correct, efficient or fast.

Currently only supports integer chromosome strings.

The following operators are implemented:

* [Roulette selection](jvm/src/test/scala/rolodato/genetics/impl/RouletteSelectionSuite.scala)
* [One-point crossover](jvm/src/test/scala/rolodato/genetics/impl/OnePointCrossoverSuite.scala)
* [Bit string mutation](jvm/src/test/scala/rolodato/genetics/impl/BitStringMutationSuite.scala)
* [Proportional integer mutation](jvm/src/test/scala/rolodato/genetics/impl/IntegerMutationSuite.scala)

# Usage

See [this test](jvm/src/test/scala/rolodato/genetics/GeneticSpec.scala) for a practical example.
