package com.app.sparkapi

import com.mongodb.Block
import org.mongodb.scala.connection.ClusterSettings

import scala.collection.JavaConverters._

object MongoDb extends  App {

  import org.mongodb.scala._

  val cl :ClusterSettings.Builder = ClusterSettings.builder()
  val settings: MongoClientSettings = MongoClientSettings.builder().applyToClusterSettings(new Block[ClusterSettings.Builder]() {
    @Override
    def apply( cl :ClusterSettings.Builder) {
      cl.hosts(List(new ServerAddress("localhost")).asJava)
    }}).build()


  val settings: MongoClientSettings = MongoClientSettings.builder()
    .applyToClusterSettings(b=> b.hosts(List(new ServerAddress("localhost")).asJava) )



  val mongoClient: MongoClient = MongoClient(settings)

  val database: MongoDatabase = mongoClient.getDatabase("mydb")


    val collection: MongoCollection[Document] = database.getCollection("mycoll")



























  // insert a document
  val document: Document = Document("_id" -> 1, "x" -> 1)
  val insertObservable: Observable[Completed] = collection.insertOne(document)


  insertObservable.subscribe(new Observer[Completed] {
    override def onNext(result: Completed): Unit = println(s"onNext: $result")
    override def onError(e: Throwable): Unit = println(s"onError: $e")
    override def onComplete(): Unit = println("onComplete")
  })

}
