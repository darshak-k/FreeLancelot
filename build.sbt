name := """FreeLancelot"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.6"

libraryDependencies += guice
libraryDependencies += ehcache
libraryDependencies ++= Seq(
  javaWs,
  ehcache,
  cacheApi,
  caffeine
)

libraryDependencies += "org.json" % "json" % "20210307"
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.13"
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test
libraryDependencies += "org.mockito" % "mockito-core" % "2.10.0" % "test"