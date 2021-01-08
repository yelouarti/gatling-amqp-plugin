import Dependencies._

enablePlugins(GatlingPlugin)
enablePlugins(GitVersioning)

lazy val root = (project in file("."))
  .settings(
    name:= "gatling-amqp-plugin",
    version:= "0.0.2-SNAPSHOT",
    libraryDependencies ++= gatling,
    libraryDependencies ++= Seq( rabbitmq, commonsPool),
    scalacOptions ++= Seq(
      "-encoding", "utf8", // Option and arguments on same line
      "-deprecation",
      "-unchecked",
      "-language:implicitConversions",
      "-language:higherKinds",
      "-language:existentials",
      "-language:postfixOps"
    )
  )