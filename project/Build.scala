import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "winflow"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "postgresql" % "postgresql" % "8.4-702.jdbc4",
      "net.sf.opencsv" % "opencsv" % "2.3"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = JAVA).settings(
      // Add your own project settings here      
    )

}
