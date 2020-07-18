name := "SPARK2.XAPI"

version := "0.1"

scalaVersion := "2.11.8"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.5"
// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.5"

// https://mvnrepository.com/artifact/org.mongodb.scala/mongo-scala-driver
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.9.0"

// https://mvnrepository.com/artifact/org.mongodb.scala/mongo-scala-bson
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-bson" % "1.0.0"
// https://mvnrepository.com/artifact/org.mongodb/bson
libraryDependencies += "org.mongodb" % "bson" % "3.12.2"
// https://mvnrepository.com/artifact/org.mongodb/mongodb-driver-core
libraryDependencies += "org.mongodb" % "mongodb-driver-core" % "3.12.2"

// https://mvnrepository.com/artifact/org.mongodb/mongodb-driver-async
libraryDependencies += "org.mongodb" % "mongodb-driver-async" % "3.12.2"

