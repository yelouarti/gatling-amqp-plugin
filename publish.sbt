ThisBuild / organization := "de.db.sus"
ThisBuild / scalaVersion := "2.12.12"

ThisBuild / publishMavenStyle := true

ThisBuild / publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/yelouarti/gatling-amqp-plugin"), //TODO change to de.db.sus
    "git@github.com:yelouarti/gatling-amqp-plugin.git" //TODO change to de.db.sus
  )
)
ThisBuild / developers := List(
  Developer(
    id = "ehmkah",
    name = "Michael Krausse",
    email = "Michael.M.Krausse-extern@deutschebahn.com",
    url = url("https://github.com/ehmkah")
  ),
  Developer(
    id    = "yelouarti",
    name  = "Younes El Ouarti",
    email = "Younes.Elouarti-extern@deutschebahn.com",
    url   = url("https://github.com/yelouarti")
  )
)

ThisBuild / description := "Plugin for support performance testing with AMQP in Gatling(3.4.x)."
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/yelouarti/gatling-amqp-plugin")) //TODO after merge in dbsus

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
