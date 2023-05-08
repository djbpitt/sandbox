ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.2"

lazy val root = (project in file("."))
  .settings(
    name := "sandbox"
  )
libraryDependencies += ("org.scala-graph" %% "graph-core" % "1.13.6").cross(CrossVersion.for3Use2_13)
libraryDependencies += ("org.scala-graph" %% "graph-dot" % "1.13.3").cross(CrossVersion.for3Use2_13)
libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.9.1" // path manipulation and io
