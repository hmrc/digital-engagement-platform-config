import sbt.{ModuleID, _}

object AppDependencies {

  val compile = Seq(

//    "uk.gov.hmrc"             %% "govuk-template"               % "5.61.0-play-27",
//    "uk.gov.hmrc"             %% "play-ui"                      % "8.20.0-play-27",
    "uk.gov.hmrc"             %% "bootstrap-frontend-play-27"   % "3.3.0"
  )

  val test = Seq(
    "uk.gov.hmrc"             %% "bootstrap-frontend-play-27"   % "3.3.0"     % "test",
    "org.scalatest"           %% "scalatest"                    % "3.0.8"     % "test",
    "org.scalacheck"          %% "scalacheck"                   % "1.13.4"    % "test",
    "org.jsoup"               %  "jsoup"                        % "1.10.2"    % "test",
    "org.mockito"             % "mockito-all"                   % "1.10.19"   % "test",
    "org.pegdown"             %  "pegdown"                    % "1.6.0"       % "test, it",
    "org.scalatestplus.play"  %% "scalatestplus-play"         % "4.0.3"       % "test, it"
  )

  val all: Seq[ModuleID] = compile ++ test
}
