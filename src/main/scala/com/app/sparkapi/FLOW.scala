package com.app.sparkapi

import  org.apache.spark.sql.functions._

object FLOW extends App with Connection {

  val foodItemsLoad = spark.read.option("header","true").csv("/home/hadoop/Desktop/online_food_items.csv")
//  df.take(10).foreach(println)
//df.show(10)
//  foodItemsLoad.printSchema()

  foodItemsLoad.createOrReplaceTempView("foodItemsData")

  val foodQuery =
    """
      |SELECT
      |productId,
      |foodType,
      |foodCode,
      |orderDate,
      |sellerCode,
      |cast(paidItem as int),
      |cast(unpaidItem as int)
      |from foodItemsData
      |ORDER BY productId,foodCode,orderDate
    """.stripMargin

  val foodFileDF = spark.sql(foodQuery)

//  foodFileDF.show(10)



 val aggDF =
    foodFileDF
      .repartition(3)
      .na.fill(0,Seq("paidItem","unPaidItem"))
      .groupBy("productId","foodCode","orderDate")
      .agg(FoodAnalyticsUDAF(col("foodType"),
      col("sellerCode"),col("paidItem"),
      col("unpaidItem"))
      .as("food_agg_result"))
      .select(
      col("productId"),
      col("foodCode"),
      col("orderDate"),
      col("food_agg_result.sellerCode").as("sellerCode"),
      col("food_agg_result.gmoIndicator").as("gmoIndicator"),
      col("food_agg_result.ngmoIndicator").as("ngmoIndicator"),
      col("food_agg_result.gmoPaidItem").as("gmoPaidItem"),
      col("food_agg_result.gmoUnpaidItem").as("gmoUnpaidItem"),
      col("food_agg_result.ngmoPaidItem").as("ngmoPaidItem"),
      col("food_agg_result.ngmoUnpaidItem").as("ngmoUnpaidItem")
    )
  println("Printing Aggregrated Food Data ")

  print(aggDF.show())





}
