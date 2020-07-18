package com.app.sparkapi

import org.apache.spark.sql.functions._


object ScalaCollection extends App with  Connection {

  val foodItemsLoad = spark.read.option("header","true").csv("/home/hadoop/Desktop/online_food_items.csv")

foodItemsLoad.printSchema()
//  foodItemsLoad.show(10)

import spark.implicits._


  val colName:Array[String] =foodItemsLoad.columns
colName.foldLeft(foodItemsLoad){(foodItemsLoad,colnsmr)=> foodItemsLoad.withColumn(colnsmr, concat(col(colnsmr) ,lit("$$$$$")) )}.show(10)



}
