import scoverage.ScoverageKeys
import sbt.Keys.resolvers
import sbt.Resolver
import uk.gov.hmrc.DefaultBuildSettings.integrationTestSettings

val appName = "digital-engagement-platform-config"

lazy val scoverageSettings = {
  Seq(
    ScoverageKeys.coverageExcludedPackages :="""uk\.gov\.hmrc\.BuildInfo;.*\.Routes;.*\.RoutesPrefix;.*\.ErrorTemplate;.*\.ErrorHandler;.*\.TestOnlyTemplate;.*\.TestOnlyView;.*\.Reverse[^.]*""",
    ScoverageKeys.coverageMinimumStmtTotal := 90,
    ScoverageKeys.coverageFailOnMinimum := false,
    ScoverageKeys.coverageHighlighting := true
  )
}

lazy val microservice = Project(appName, file("."))
  .enablePlugins(play.sbt.PlayScala, SbtDistributablesPlugin, ScoverageSbtPlugin)
  .disablePlugins(JUnitXmlReportPlugin)
  .settings(
    majorVersion                     := 0,
    libraryDependencies              ++= AppDependencies.all,
    scalaVersion := "2.13.12",
    PlayKeys.playDefaultPort := 9957,
    scoverageSettings
  )
  .configs(IntegrationTest)
  .settings(integrationTestSettings(): _*)
  .settings(resolvers += Resolver.jcenterRepo)
