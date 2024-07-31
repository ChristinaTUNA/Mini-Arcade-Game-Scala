package xy.christina.game.view

import scalafx.Includes._
import scalafx.scene.control.{Button, Label}
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

  def initialize(): Unit = {
    updateView()
    setupButtonEvents()
    setupKeyEvents()
    rootPane.requestFocus() // Ensure the rootPane is focusable
  }

  private def setupKeyEvents(): Unit = {
    rootPane.onKeyPressed = (event: KeyEvent) => handleKeyEvent(event)
  }

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

  private def handleKeyEvent(event: KeyEvent): Unit = {
    println(s"Key Pressed: ${event.code}") // Debug print
    event.code match {
      case KeyCode.Up => handleInput("Flour") // Simulate button press
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

//  private def setupFocusListener(): Unit = {
//    rootPane.focusedProperty().addListener { (_, oldValue, newValue) =>
//      if (!newValue) {
//        rootPane.requestFocus() // Re-focus on rootPane if focus is lost
//      }
//    }
//  }
  private def handleInput(ingredient: String): Unit = {
    println(s"Handling Input: $ingredient") // Debug print
    if (game.handleInput(ingredient)) {
      if (game.isGameOver) {
        gameOver()
      } else {
        updateView()
      }
    }
  }

  private def gameOver(): Unit = {
    scoreLabel.text = "Game Over"
    scoreLabel.style = "-fx-text-fill: red; -fx-font-size: 24px;"
    rootPane.disable = true // Disable further interaction
  }

  private def updateView(): Unit = {
    scoreLabel.text = s"Score: ${game.getScore}"
    recipeLabel.text = s"${game.getCurrentRecipe.name}"
    lifeLabel.text = s"Lives: ${game.getLives}"
    ingredientGrid.getChildren.clear()

    // Display current recipe ingredients in the grid
    game.getCurrentRecipe.ingredients.zipWithIndex.foreach { case ((ingredient, quantity), index) =>
      val row = index
      val col1 = new Label(s"x$quantity")
      val col2 = new Label(ingredient)
      ingredientGrid.add(col1, 0, row)
      ingredientGrid.add(col2, 1, row)
    }
  }
}
