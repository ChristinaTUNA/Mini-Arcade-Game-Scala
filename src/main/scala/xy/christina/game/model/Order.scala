package xy.christina.game.model

import scala.util.Random

case class Order(name: String, sequence: Seq[String])

object Order {
  private val recipes: Map[String, Seq[String]] = Map(
    "Bread" -> Seq("LEFT", "LEFT", "UP"),
    "Egg Tart" -> Seq("LEFT", "UP", "RIGHT"),
    "Cake" -> Seq("DOWN", "UP", "RIGHT", "LEFT")
  )

  def generateRandomOrder(): Order = {
    val randomRecipe = Random.shuffle(recipes.keys).head
    Order(randomRecipe, recipes(randomRecipe))
  }
}
