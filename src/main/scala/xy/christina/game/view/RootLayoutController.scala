package xy.christina.game.view

import scalafx.event.ActionEvent
import scalafxml.core.macros.sfxml
import xy.christina.game.MyApp

@sfxml
class RootLayoutController {
  def handleQuitGame(action: ActionEvent): Unit = {
    MyApp.showHomePage()
  }

}
