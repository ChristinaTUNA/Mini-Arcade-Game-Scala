package xy.christina.game.view

import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml
import xy.christina.game.MyApp

@sfxml
class HomeController {
  def handleStartGame(action: ActionEvent) ={
     MyApp.showGamePage()
  }

  def handleInstruction(action: ActionEvent)={
    MyApp.showInstruction()
  }
}
