name := """play-colab-tool"""
organization := "com.pluralsight"
version := "1.0-SNAPSHOT"

scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % "2.6.20",
  "com.typesafe.play" %% "play-akka-http-server" % "2.8.22",
  "com.h2database" % "h2" % "2.2.220",
  "org.hibernate" % "hibernate-core" % "5.6.15.Final",
  "javax.persistence" % "javax.persistence-api" % "2.2",
  "com.typesafe.play" %% "play-java-jpa" % "2.8.22",
  "com.typesafe.play" %% "play-guice" % "2.8.22",
  "com.typesafe.play" %% "filters-helpers" % "2.8.22"

)

