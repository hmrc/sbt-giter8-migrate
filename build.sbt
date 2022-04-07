name := """sbt-giter8-migrate"""
organization := "uk.gov.hmrc"
version := "0.1-SNAPSHOT"

enablePlugins(SbtPlugin)

majorVersion := 0
scalaVersion := "2.12.15"

// set up 'scripted; sbt plugin for testing sbt plugins
scriptedLaunchOpts ++=
  Seq("-Xmx1024M", "-Dplugin.version=" + version.value)

console / initialCommands := """import uk.gov.hmrc._"""

addSbtPlugin("org.foundweekends.giter8" % "sbt-giter8-scaffold" % "0.11.0")