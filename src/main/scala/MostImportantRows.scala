import org.apache.spark.sql.SparkSession

object MostImportantRows extends App {

  val spark = SparkSession
    .builder()
    .master("local[*]")
    .appName("MostImportantRows")
    .config("spark.some.config.option", "some-value")
    .getOrCreate()

  import spark.implicits._
  import org.apache.spark.sql.functions._

  val input = Seq(
    (1, "MV1"),
    (1, "MV2"),
    (2, "VPV"),
    (2, "Others")).toDF("id", "value")


  val names = Seq(
    "MV1",
    "MV2",
    "VPV",
    "Others"
  ).zipWithIndex.toDF("name", "id")

  val output = input.join(names)
    .where($"value" === $"name")

  output.show
}
