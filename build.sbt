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