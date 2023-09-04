import Dependencies._

ThisBuild / scalaVersion     := "2.13.11"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "gloval.vigil"

lazy val root = (project in file("."))
  .settings(
    name := "be-challenge",
    libraryDependencies ++= Seq(
      scalactic,
      scalaTest % Test
    )
  )
