package xy.christina.game

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import javafx.{scene => jfxs}
import scalafx.scene.layout.StackPane
import scalafxml.core.{FXMLLoader, NoDependencyResolver}


object MyApp extends JFXApp{
  val rootResource = getClass.getResource(("view/RootLayout.fxml"))
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  loader.load();
  val roots = loader.getRoot[jfxs.layout.AnchorPane]

  //initialize stage
  stage = new PrimaryStage {
    title = "Kopitiam"
    scene = new Scene {
      root = roots
    }
  }

  def showHomePage(): Unit = {
    val resource = getClass.getResource("view/Home.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val homePage = loader.getRoot[jfxs.layout.Pane]
    val contentPane = roots.lookup("#contentPane").asInstanceOf[StackPane]
    contentPane.getChildren.clear()
    contentPane.getChildren.add(homePage)

  }
  def showGamePage(): Unit = {
    val resource = getClass.getResource("view/Game.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val gamePage = loader.getRoot[jfxs.layout.Pane]
    val contentPane = roots.lookup("#contentPane").asInstanceOf[StackPane]
    contentPane.getChildren.clear()
    contentPane.getChildren.add(gamePage)
  }

  def showScorePage(): Unit = {
    val resource = getClass.getResource("view/ScoreBoard.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val scorePage = loader.getRoot[jfxs.layout.Pane]
    val contentPane = roots.lookup("#contentPane").asInstanceOf[StackPane]
    contentPane.getChildren.clear()
    contentPane.getChildren.add(scorePage)
  }
  // call to display HomePage when app start
  showHomePage()
}