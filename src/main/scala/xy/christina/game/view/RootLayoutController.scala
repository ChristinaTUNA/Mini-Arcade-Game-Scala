package xy.christina.game.view

import scalafx.event.ActionEvent
import scalafx.scene.control.Button
import scalafxml.core.macros.sfxml
import xy.christina.game.MyApp

@sfxml
class RootLayoutController(
                            private val pauseButton: Button
                          ) {
  def handleQuitGame(action: ActionEvent): Unit = {
    MyApp.showHomePage()
  }

}
