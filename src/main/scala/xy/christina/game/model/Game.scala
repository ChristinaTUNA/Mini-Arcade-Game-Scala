package xy.christina.game.model

import scala.collection.mutable.ListBuffer

class Game {
  private var score = 0
  private var lives = 3
  private val recipes = Recipe.allRecipes
  private var currentRecipe = recipes.head
  private val currentInput = ListBuffer[String]()
  private var timer: Int = 10 // Initial time for each recipe

  def getCurrentRecipe: Recipe = currentRecipe
  def getLives: Int = lives
  def getScore: Int = score
  def getCurrentInput: List[String] = currentInput.toList
  def getTimer: Int = timer

  def handleInput(ingredient: String): Boolean = {
    currentInput += ingredient
    println(currentInput)
    val recipeInput = getRecipeInput

    if (isInputCorrect(recipeInput)) {
      if (currentInput.size == recipeInput.size) {
        completeRecipe()
        true
      } else {
        false
      }
    } else {
      handleIncorrectInput()
      false
    }
  }

  private def getRecipeInput: List[String] = {
    currentRecipe.ingredients.flatMap { case (ing, qty) => List.fill(qty)(ing) }
  }

  private def isInputCorrect(recipeInput: List[String]): Boolean = {
    currentInput == recipeInput.take(currentInput.size)
  }

  private def completeRecipe(): Unit = {
    score += 10
    currentInput.clear()
    switchToNextRecipe()
  }

  private def handleIncorrectInput(): Unit = {
    lives -= 1
    currentInput.clear()
    switchToNextRecipe()
  }


  private def switchToNextRecipe(): Unit = {
    currentRecipe = recipes((recipes.indexOf(currentRecipe) + 1) % recipes.size)
    timer = 10 // Reset timer for the new recipe
  }

  def tickTimer(): Unit = {
    timer -= 1
    if (timer <= 0) {
      handleIncorrectInput()
    }
  }

  def isGameOver: Boolean = lives <= 0
}
