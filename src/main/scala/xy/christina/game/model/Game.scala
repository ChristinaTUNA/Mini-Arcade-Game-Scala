package xy.christina.game.model

import scala.collection.mutable.ListBuffer

class Game(playerName: String) {
  private val player = new Player(playerName)
  private var currentRecipe = RecipeFactory.createRandomRecipe()
  private val currentInput = ListBuffer[String]()
  private val timer = new GameTimer(10) // Initial time for each recipe

  def getCurrentRecipe: RecipeType = currentRecipe
  def getLives: Int = player.lives.getLives
  def getScore: Int = player.score.getPoints
  def getCurrentInput: List[String] = currentInput.toList
  def getTimer: Int = timer.getTimeRemaining

  def handleInput(ingredient: String): Boolean = {
    currentInput += ingredient
    println(currentInput)
    val recipeInput = getRecipeInput

    if (isInputCorrect(recipeInput)) {
      if (currentInput.size == recipeInput.size) {
        handleCorrectInput()
        true
      } else false
    } else {
      handleIncorrectInput()
      false
    }
  }

  private def getRecipeInput: List[String] = {
    currentRecipe.ingredients.flatMap { ingredient =>
      List.fill(ingredient.quantity)(ingredient.name)
    }
  }

  private def isInputCorrect(recipeInput: List[String]): Boolean = {
    currentInput == recipeInput.take(currentInput.size)
  }

  private def handleCorrectInput(): Unit = {
    player.score.addPoints(10)
    currentInput.clear()
  }

  private def handleIncorrectInput(): Unit = {
    player.lives.loseLife()
    currentInput.clear()
    timer.reset()
  }

  def switchToNextRecipe(): Unit = {
    currentRecipe = RecipeFactory.createRandomRecipe()
    timer.reset() // Reset timer for the new recipe
  }

  def tickTimer(): Unit = {
    timer.tick()
    if (timer.isTimeUp) {
      handleIncorrectInput()
    }
  }

  def isGameOver: Boolean = player.lives.isDead
}
