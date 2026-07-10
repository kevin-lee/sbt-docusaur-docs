
ThisBuild / organization := props.Org
ThisBuild / scalaVersion := props.ProjectScalaVersion
ThisBuild / developers := List(
  Developer(
    props.GitHubUsername,
    "Kevin Lee",
    "kevin.code@kevinlee.io",
    url(s"https://github.com/${props.GitHubUsername}"),
  )
)

ThisBuild / homepage := url(s"https://github.com/${props.GitHubUsername}/${props.ProjectName}").some

ThisBuild / startYear := 2020.some

lazy val root = (project in file("."))
  .enablePlugins(DocusaurPlugin)
  .settings(
    name := props.ProjectName,
    description := "doc site for sbt-docusaur",
    Compile / console / scalacOptions := scalacOptions.value diff List("-Ywarn-unused-import", "-Xfatal-warnings"),

    /* Docs { */
    docusaurDir := (ThisBuild / baseDirectory).value / "website",
    docusaurBuildDir := docusaurDir.value / "build",
    /* } Docs */

  )

lazy val props =
  new {

    val Org = "io.kevinlee"

    private val gitHubRepo = findRepoOrgAndName

    val GitHubUsername = gitHubRepo.fold("kevin-lee")(_.orgToString)
    val ProjectName    = gitHubRepo.fold("sbt-docusaur-docs")(_.nameToString)

    val ProjectScalaVersion = "2.12.18"

  }

lazy val libs = new {}
