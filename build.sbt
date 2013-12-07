name := "play-entitlement-reactive"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm
)

libraryDependencies += "postgresql" % "postgresql" % "9.1-901.jdbc4"

play.Project.playScalaSettings
