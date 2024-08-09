package xy.christina.game.view

import scalafx.event.ActionEvent
import scalafx.scene.control.Button
import scalafxml.core.macros.sfxml
import xy.christina.game.MyApp

@sfxml
class RootLayoutController (
                             private val pauseButton: Button
                           ) {
  private val gameController: Option[GameController] = None

  def handleQuitGame(action: ActionEvent): Unit = {
    MyApp.showHomePage()
  }

//  def handlePauseGame(action: ActionEvent): Unit = {
//    gameController.foreach { controller =>
//      if (controller.getIsPaused) {
//        controller.resumeGame()
//        pauseButton.text = "Pause"
//      } else {
//        controller.pauseGame()
//        pauseButton.text = "Resume"
//      }
//    }
//  }
  //  def handleAudio(): Unit = {
  //
  //  }
}
