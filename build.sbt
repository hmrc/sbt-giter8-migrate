import uk.gov.hmrc.DefaultBuildSettings

name := """sbt-giter8-migrate"""
organization := "uk.gov.hmrc"
version := "0.1-SNAPSHOT"

sbtPlugin := true
majorVersion := 0
scalaVersion := "2.12.15"

// choose a test framework

// utest
//libraryDependencies += "com.lihaoyi" %% "utest" % "0.7.10" % "test"
//testFrameworks += new TestFramework("utest.runner.Framework")

// ScalaTest
//libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.9" % "test"
//libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % "test"

// Specs2
//libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "4.12.8" % "test")
//scalacOptions in Test ++= Seq("-Yrangepos")

console / initialCommands := """import uk.gov.hmrc._"""

enablePlugins(ScriptedPlugin)
// set up 'scripted; sbt plugin for testing sbt plugins
scriptedLaunchOpts ++=
  Seq("-Xmx1024M", "-Dplugin.version=" + version.value)

DefaultBuildSettings.scalaSettings

//    .settings(DefaultBuildSettings.scalaSettings: _*)
//    .settings(DefaultBuildSettings.defaultSettings(): _*)
//    .settings(SbtDistributablesPlugin.publishingSettings: _*)

