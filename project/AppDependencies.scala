import sbt.{ModuleID, _}

object AppDependencies {

  val compile: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"             %% "bootstrap-frontend-play-28"   % "4.3.0"
  )

  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"             %% "bootstrap-frontend-play-28"   % "4.3.0"     % "test",
    "org.scalatest"           %% "scalatest"                    % "3.0.8"     % "test",
    "org.scalacheck"          %% "scalacheck"                   % "1.13.4"    % "test",
    "org.jsoup"               %  "jsoup"                        % "1.10.2"    % "test",
    "org.mockito"             % "mockito-all"                   % "1.10.19"   % "test",
    "org.pegdown"             %  "pegdown"                    % "1.6.0"       % "test, it",
    "org.scalatestplus.play"  %% "scalatestplus-play"         % "5.0.0"       % "test, it"
  )

  val all: Seq[ModuleID] = compile ++ test
}
