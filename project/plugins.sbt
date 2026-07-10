logLevel := sbt.Level.Warn

addSbtPlugin("io.kevinlee" % "sbt-docusaur" % "0.21.0")

val sbtDevOopsVersion = "3.6.0"
addSbtPlugin("io.kevinlee" % "sbt-devoops-sbt-extra" % sbtDevOopsVersion)
addSbtPlugin("io.kevinlee" % "sbt-devoops-github"    % sbtDevOopsVersion)
addSbtPlugin("io.kevinlee" % "sbt-devoops-starter"   % sbtDevOopsVersion)
