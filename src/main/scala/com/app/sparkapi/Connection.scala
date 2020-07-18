package com.app.sparkapi


import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql._

trait Connection {


  Logger.getLogger("org").setLevel(Level.OFF)
  Logger.getLogger("akka").setLevel(Level.OFF)
  Logger.getLogger("myLogger").setLevel(Level.OFF)


  //  val wareHouseLocation = "hdfs://localhost:9000/user/hive/warehouse"


  val spark = SparkSession.builder.master("local[3]").appName("sparkRdd")
    // .config("spark.cassandra.connection.host",cassHostName)
    //.config("spark.closure.serializer","org.apache.spark.serializer.JavaSerializer")
    .config("spark.rdd.compress", "true")
    .config("spark.io.compression.codec", "snappy")
    .config("executor-memory",2)
    .config("spark.submit.deployMode","client")
    .config("executor-cores", 2)
    //      .config("spark.sql.warehouse.dir", wareHouseLocation)
    .config("spark.driver.allowMultipleContexts", "true")
    //.config("spark.driver.memory", "0g")
    .config("num-executors",2)
    //      .enableHiveSupport()
    .getOrCreate()




}

