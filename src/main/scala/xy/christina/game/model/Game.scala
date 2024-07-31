package xy.christina.game.model

import scala.collection.mutable.ListBuffer

class Game {
  private var score = 0
  private var lives = 3
  private var recipes = Recipe.allRecipes
  private var currentRecipe = recipes.head
  private var currentInput = ListBuffer[String]()

  def getCurrentRecipe: Recipe = currentRecipe

  def getLives: Int = lives

  def handleInput(ingredient: String): Boolean = {
    currentInput += ingredient
    val recipeInput = currentRecipe.ingredients.flatMap { case (ing, qty) => List.fill(qty)(ing) }
    if (currentInput == recipeInput.take(currentInput.size)) {
      if (currentInput.size == recipeInput.size) {
        score += 10
        currentInput.clear()
        switchToNextRecipe()
        true // Successfully completed the recipe
      } else {
        false // Still matching the recipe
      }
    } else {
      println("wrong input")
      lives -= 1
      currentInput.clear() // Reset on wrong input
      false
    }
  }

  def getScore: Int = score

  private def switchToNextRecipe(): Unit = {
    currentRecipe = recipes((recipes.indexOf(currentRecipe) + 1) % recipes.size)
  }

  def isGameOver: Boolean = lives <= 0
}
