package xy.christina.game.view

import scalafxml.core.macros.sfxml
import xy.christina.game.MyApp

@sfxml
class HomeController {
  def handleStartGame(): ={
    MyApp.showGamePage()
  }

  def handleViewScores(): ={
    MyApp.showScorePage()
  }
}
