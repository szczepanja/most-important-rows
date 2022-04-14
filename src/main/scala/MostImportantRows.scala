import org.apache.spark.sql.SparkSession

object MostImportantRows extends App {

  val spark = SparkSession
    .builder()
    .master("local[*]")
    .appName("MostImportantRows")
    .config("spark.some.config.option", "some-value")
    .getOrCreate()

  import spark.implicits._

  val input = Seq(
    (1, "MV1"),
    (1, "MV2"),
    (2, "VPV"),
    (2, "Others")).toDF("id", "value")

  input.show
}
