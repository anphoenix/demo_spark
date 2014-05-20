name := "Correct Spark LR Project"

version := "1.0"

scalaVersion := "2.10.3"

libraryDependencies += "org.apache.spark" %% "spark-core" % "0.9.1"

libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.2.0"

libraryDependencies  += "org.scalanlp" % "breeze_2.10" % "0.7"

libraryDependencies  += "org.scalanlp" % "breeze-natives_2.10" % "0.7"

resolvers += "Akka Repository" at "http://repo.akka.io/releases/"

resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"

