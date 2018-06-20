lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.1",
      version      := "0.1.0-SNAPSHOT",
      javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
      // For project with only Java sources. In order to compile Scala sources, remove the following two lines.
      crossPaths := false,
      autoScalaLibrary := false
    )),
    name := "s4n-drones-para-domicilio",
    libraryDependencies ++= Seq(
      "io.vavr" % "vavr" % "0.9.2",
      "io.vavr" % "vavr" % "0.9.2",
      "junit" % "junit" % "4.12" % "test",
      "com.novocode" % "junit-interface" % "0.11" % "test",
      "org.powermock" % "powermock" % "1.4.10" % "test",
      "org.mockito" % "mockito-all" % "1.10.19" % Test,
      "org.mockito" % "mockito-core" % "2.19.0" % Test,
      "org.powermock" % "powermock-module-junit4" % "1.7.4" % Test,
      "org.powermock" % "powermock-core" % "1.7.1" % Test,
      "org.powermock" % "powermock-api-mockito" % "1.5.1" % "test"

    )
  )