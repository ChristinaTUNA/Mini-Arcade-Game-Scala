package xy.christina.game.view

import scalafx.Includes._
import scalafx.scene.control.{Button, Label}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.input.{KeyCode, KeyEvent}
import scalafx.scene.layout.{AnchorPane, GridPane}
import scalafxml.core.macros.sfxml
import xy.christina.game.model.Game

@sfxml
class GameController(
                      private val rootPane: AnchorPane,
                      private val scoreLabel: Label,
                      private val recipeLabel: Label,
                      private val ingredientGrid: GridPane,
                      private val currentInputGrid: GridPane,
                      private val lifeLabel: Label,
                      private val upButton: Button,
                      private val downButton: Button,
                      private val leftButton: Button,
                      private val rightButton: Button,
                      private val wButton: Button,
                      private val aButton: Button,
                      private val sButton: Button,
                      private val dButton: Button
                    ) {
  private val game = new Game()
  private var currentInput = List[String]()
  private val maxInputSize = 5

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

  def initialize(): Unit = {
    updateView()

    setupButtonEvents()
    setupKeyEvents()
    setupFocusListener()
    rootPane.requestFocus() // Ensure the rootPane is focusable
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
    rootPane.focusedProperty().addListener { (_, oldValue, newValue) =>
      if (!newValue) {
        rootPane.requestFocus()
      }
    }
  }

  // Handle key events to simulate button press
  private def handleKeyEvent(event: KeyEvent): Unit = {
    println(s"Key Pressed: ${event.code}") // Debug print
    updateCurrentInputGrid()
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
    currentInput = (currentInput :+ ingredient).takeRight(maxInputSize)
    println(currentInput)
    updateCurrentInputGrid()
    if (game.handleInput(ingredient)) {

      if (game.isGameOver) {
        gameOver()
      } else {
        updateView()
      }
    } else {
      if (game.getLives <= 0) {
        gameOver()
      } else {
        updateView()
      }
    }
  }

  // Update the current input grid with images
  private def updateCurrentInputGrid(): Unit = {
    currentInputGrid.getChildren.clear()
    currentInput.zipWithIndex.foreach { case (ingredient, index) =>
      val imageView = new ImageView(ingredientImages(ingredient))
      imageView.fitWidth = 32
      imageView.fitHeight = 28
      currentInputGrid.add(imageView, index, 0)
    }
  }

  // Update the view with the latest game state
  private def updateView(): Unit = {
    scoreLabel.text = s"Score: ${game.getScore}"
    recipeLabel.text = s"${game.getCurrentRecipe.name}"
    lifeLabel.text = s"Lives: ${game.getLives}"
    ingredientGrid.getChildren.clear()


    game.getCurrentRecipe.ingredients.zipWithIndex.foreach { case ((ingredient, quantity), index) =>
      val row = index
      val col1 = new Label(s"x$quantity")
      val col2 = new Label(ingredient)
      ingredientGrid.add(col1, 0, row)
      ingredientGrid.add(col2, 1, row)
    }
  }

  // Handle game over state
  private def gameOver(): Unit = {
    scoreLabel.text = "Game Over"
    scoreLabel.style = "-fx-text-fill: red; -fx-font-size: 24px;"
    rootPane.disable = true // Disable further interaction
  }
}
