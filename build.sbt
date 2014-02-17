organization := "com.sqality.scct"

name := "sbt-scct"

version := "0.3.1-SNAPSHOT"

scalaVersion := "2.10.2"

crossScalaVersions := Seq("2.10.3", "2.11.0-M7")

sbtPlugin := true

crossBuildingSettings

CrossBuilding.crossSbtVersions := Seq("0.13")

resolvers += "Sonatype OSS" at "https://oss.sonatype.org/content/repositories/snapshots"

//resolvers += Resolver.url("local-ivy", new URL("file://" + Path.userHome.absolutePath + "/.ivy2/local"))(Resolver.ivyStylePatterns)

libraryDependencies += "com.sqality.scct" %% "scct" % "0.3.1-SNAPSHOT"

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

pomExtra := <url>http://sqality.com</url>
  <licenses>
    <license>
      <name>Apache License, Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:SCCT/sbt-scct.git</url>
    <connection>scm:git:git@github.com:SCCT/sbt-scct.git</connection>
  </scm>
  <developers>
    <developer>
      <id>mtkopone</id>
      <name>Mikko Koponen</name>
      <url>http://mtkopone.github.com</url>
    </developer>
  </developers>

credentials += Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", System.getenv("SONATYPE_USER"), System.getenv("SONATYPE_PASS"))
