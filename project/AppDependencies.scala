import sbt.{ModuleID, _}

object AppDependencies {

  val compile: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"             %% "bootstrap-frontend-play-28"   % "5.21.0"
  )

  val test: Seq[ModuleID] = Seq(
    "org.scalatest"           %% "scalatest"                    % "3.2.3"     % "test",
    "org.scalacheck"          %% "scalacheck"                   % "1.15.4"    % "test",
    "org.jsoup"               %  "jsoup"                        % "1.14.3"    % "test",
    "org.mockito"             %  "mockito-all"                  % "1.10.19"   % "test",
    "org.pegdown"             %  "pegdown"                      % "1.6.0"     % "test",
    "org.scalatestplus.play"  %% "scalatestplus-play"           % "5.1.0"     % "test",
    "com.vladsch.flexmark"    %  "flexmark-all"                 % "0.35.10"   % "test"
  )

  val all: Seq[ModuleID] = compile ++ test
}
