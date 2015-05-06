name := "genetics"

organization := "rolodato"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.6"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

scalacOptions ++= List("-feature","-deprecation", "-unchecked", "-Xlint")
