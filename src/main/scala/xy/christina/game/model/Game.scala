package xy.christina.game.model

import scala.collection.mutable.ListBuffer

class Game (player: Player){

  private var currentRecipe: Option[Recipe] = None
  private val inputSequence = ListBuffer[Ingredient]()
  def startNewGame(): Unit = {
    currentRecipe = Some(Recipes.bread) // For simplicity, start with bread. You can randomize or choose another way to select recipes.
    inputSequence.clear()
    println(s"New game started. Recipe: ${currentRecipe.get.name}")
  }

  def handleInput(key: String): Unit = {
    val ingredient = key match {
      case "Up" => Flour
      case "Down" => Milk
      case "Left" => Egg
      case "Right" => Butter
      case "W" => Cream
      case "A" => Chocolate
      case "S" => Blueberry
      case "D" => Strawberry
      case _ => return
    }

    inputSequence += ingredient
    println(s"Input: $key (${ingredient.toString}), Current Sequence: ${inputSequence.map(_.toString).mkString(", ")}")

    checkSequence()
  }

  private def checkSequence(): Unit = {
    if (currentRecipe.isDefined && inputSequence == currentRecipe.get.ingredients) {
      println(s"Correct! You've made ${currentRecipe.get.name}")
      startNewGame() // Start a new game or proceed to the next recipe
    } else if (inputSequence.length >= currentRecipe.get.ingredients.length) {
      println("Incorrect sequence. Try again!")
      inputSequence.clear() // Clear sequence and try again
    }
  }
}
