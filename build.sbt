inThisBuild(List(
  sonatypeProfileName := "org.virtuslab",
  organization := "org.virtuslab",
  homepage := Some(url("https://github.com/VirtusLab/pretty-stacktraces")),
  licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  developers := List(
    Developer(
      "BarkingBad",
      "Andrzej Ratajczak",
      "andrzej.ratajczak98@gmail.com",
      url("https://twitter.com/aj_ratajczak")
    ),
    Developer(
      "romanowski",
      "Krzysztof Romanowski",
      "kromanowski@virtuslab.com",
      url("https://twitter.com/RomanowskiKr")
    )
  )
))

val scala3Version = "3.1.0-RC1-bin-20210820-68044a6-NIGHTLY"
val Examples = config("examples") extend Compile

lazy val root = project
  .in(file("."))
  .configs(Examples)
  .settings(
    organization := "org.virtuslab",
    name := "pretty-stacktraces",

    scalaVersion := scala3Version,
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",
    libraryDependencies += "org.scala-lang" %% "scala3-tasty-inspector" % scalaVersion.value,

    inConfig(Examples)(Defaults.compileSettings),
    Examples / sourceDirectory := baseDirectory.value / "src" / "examples",
  )
