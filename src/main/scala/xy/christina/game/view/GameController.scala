package xy.christina.game.view

import scalafx.Includes._
import scalafx.animation.{KeyFrame, Timeline}
import scalafx.scene.control.{Button, Label}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.input.{KeyCode, KeyEvent}
import scalafx.scene.layout.{AnchorPane, GridPane}
import scalafx.util.Duration
import scalafxml.core.macros.sfxml
import xy.christina.game.model.Game


@sfxml
class GameController(
                      private val rootPane: AnchorPane,
                      private val scoreLabel: Label,
                      private val recipeLabel: Label,
                      private val ingredientGrid: GridPane,
                      private val currentInputGrid: GridPane,
                      private val displayRecipeGrid: GridPane,
                      private val lifeLabel: Label,
                      private val timerLabel: Label,
                      private val upButton: Button,
                      private val downButton: Button,
                      private val leftButton: Button,
                      private val rightButton: Button,
                      private val wButton: Button,
                      private val aButton: Button,
                      private val sButton: Button,
                      private val dButton: Button,
                    ) {
  private val game = new Game("Player1")

  private val ingredientImages = Map(
    "Flour" -> new Image("image/flour.png"),
    "Egg" -> new Image("image/egg.png"),
    "Milk" -> new Image("image/milk.png"),
    "Butter" -> new Image("image/butter.png"),
    "Cream" -> new Image("image/cream.png"),
    "Chocolate" -> new Image("image/choco.png"),
    "Blueberry" -> new Image("image/blueberry.png"),
    "Strawberry" -> new Image("image/strawberry.png")
  )

  private val RecipeImages = Map(
    "Bread" -> new Image("image/loafbread.png"),
    "Cake" -> new Image("image/strawberryShortcake.png"),
    "Egg Tart" -> new Image("image/eggtart.png"),
    "Swiss Roll" -> new Image("image/SwissRoll.png"),
    "Pie" -> new Image("image/blueberry pie.png"),
    "Choco Cake" -> new Image("image/ChocolateCake.png"),
    "Baguette" -> new Image("image/Baguette.png"),
    "Bagel" -> new Image("image/bagel.png"),
  )

  private val timeline = new Timeline {
    cycleCount = Timeline.Indefinite
    keyFrames = Seq(
      KeyFrame(Duration(1000), onFinished = _ => {
        game.tickTimer()
        updateTimerLabel()
        updateView()
        if (game.isGameOver) {
          gameOver()
        }
      })
    )
  }

  def initialize(): Unit = {
    setupButtonEvents()
    setupKeyEvents()
    setupFocusListener()
    rootPane.requestFocus() // Ensure the rootPane is focusable
    timeline.play() // Start the timer
    updateView()
  }

  // Setup for button click events
  private def setupButtonEvents(): Unit = {
    upButton.onAction = _ => handleInput("Flour")
    downButton.onAction = _ => handleInput("Egg")
    leftButton.onAction = _ => handleInput("Milk")
    rightButton.onAction = _ => handleInput("Butter")
    wButton.onAction = _ => handleInput("Cream")
    aButton.onAction = _ => handleInput("Chocolate")
    sButton.onAction = _ => handleInput("Blueberry")
    dButton.onAction = _ => handleInput("Strawberry")
  }

  // Setup for key press events
  private def setupKeyEvents(): Unit = {
    rootPane.onKeyPressed = (event: KeyEvent) => handleKeyEvent(event)
  }

  // Setup to ensure the rootPane retains focus
  private def setupFocusListener(): Unit = {
    rootPane.focusedProperty().addListener { (_, _, newValue) =>
      if (!newValue) {
        rootPane.requestFocus()
      }
    }
  }

  // Handle key events to simulate button press
  private def handleKeyEvent(event: KeyEvent): Unit = {
    println(s"Key Pressed: ${event.code}") // Debug print
    event.code match {
      case KeyCode.Up => handleInput("Flour")
      case KeyCode.Down => handleInput("Egg")
      case KeyCode.Left => handleInput("Milk")
      case KeyCode.Right => handleInput("Butter")
      case KeyCode.W => handleInput("Cream")
      case KeyCode.A => handleInput("Chocolate")
      case KeyCode.S => handleInput("Blueberry")
      case KeyCode.D => handleInput("Strawberry")
      case _ =>
    }
  }

  // Handle input for ingredients
  private def handleInput(ingredient: String): Unit = {
    val isCorrect = game.handleInput(ingredient)
    updateCurrentInputGrid()
    if (game.isGameOver) {
      gameOver()
    } else {
      if (isCorrect) {
        displayRecipeImage()

        // Use a Timeline to hide the recipe image after 2 seconds
        val hideTimeline = new Timeline {
          cycleCount = 1
          keyFrames = Seq(
            KeyFrame(Duration(800), onFinished = _ => {
              hideRecipeImage()
              game.switchToNextRecipe()
              updateCurrentInputGrid()
              updateView()
            })
          )
        }
        hideTimeline.play()
      } else {
        updateCurrentInputGrid()
        updateView()
      }
    }
  }

  // Update the current input grid with images
  private def updateCurrentInputGrid(): Unit = {
    currentInputGrid.getChildren.clear()
    game.getCurrentInput.zipWithIndex.foreach { case (ingredient, index) =>
      val imageView = new ImageView(ingredientImages(ingredient))
      imageView.fitWidth = 30
      imageView.fitHeight = 30
      currentInputGrid.add(imageView, index, 0)
    }
  }

  // Update the view with the latest game state
  private def updateView(): Unit = {
    scoreLabel.text = s"Score: ${game.getScore}"
    recipeLabel.text = s"${game.getCurrentRecipe.recipeName}"
    lifeLabel.text = s"Lives: ${game.getLives}"
    updateIngredientGrid()
    updateTimerLabel()
  }

  // Update the timer label
  private def updateTimerLabel(): Unit = {
    timerLabel.text = s"${game.getTimer}"
  }

  private def displayRecipeImage(): Unit = {
    val recipeImage = new ImageView(RecipeImages(game.getCurrentRecipe.recipeName))
    recipeImage.fitWidth = 70
    recipeImage.fitHeight = 70
    displayRecipeGrid.getChildren.clear()
    displayRecipeGrid.add(recipeImage, 0, 0)
  }

  private def hideRecipeImage(): Unit = {
    displayRecipeGrid.getChildren.clear()
  }

  // Update the ingredient grid
  private def updateIngredientGrid(): Unit = {
    ingredientGrid.getChildren.clear()
    ingredientGrid.style = "-fx-font-size: 9px;"
    game.getCurrentRecipe.ingredients.zipWithIndex.foreach { case (ingredient, index) =>
      val row = index
      val col1 = new Label(s"x${ingredient.quantity}")
      val col2 = new Label(ingredient.ingredientName)
      ingredientGrid.add(col1, 0, row)
      ingredientGrid.add(col2, 1, row)
    }
  }

  // Handle game over state
  private def gameOver(): Unit = {
    scoreLabel.text = s"Game Over \nScore: ${game.getScore}"
    scoreLabel.style = "-fx-text-fill: red; -fx-font-size: 18px;"
    rootPane.disable = true // Disable further interaction
    timeline.stop() // Stop the timer
  }
}