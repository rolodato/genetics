# genetics

Implement genetic algorithms in Scala.
This is only a learning project, not guaranteed to be correct, efficient or fast.

Currently only supports integer chromosome strings.

The following operators are implemented:

* [Roulette selection](src/main/scala/rolodato/genetics/impl/RouletteSelection.scala)
* [One-point crossover](src/main/scala/rolodato/genetics/impl/OnePointCrossover.scala)
* [Bit string mutation](src/main/scala/rolodato/genetics/impl/BitStringMutation.scala)
* [Proportional integer mutation](src/main/scala/rolodato/genetics/impl/IntegerMutation.scala)
