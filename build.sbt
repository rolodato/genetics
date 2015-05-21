name := "genetics-root"

lazy val root = project.in(file(".")).
  aggregate(geneticsJS, geneticsJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val genetics = crossProject.in(file(".")).
  settings(
    name := "genetics",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.11.6"
  ).
  jvmSettings(
    libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
  )

lazy val geneticsJS = genetics.js
lazy val geneticsJVM = genetics.jvm

scalacOptions ++= List("-feature","-deprecation", "-unchecked", "-Xlint")
