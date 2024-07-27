package xy.christina.game

import javafx.{scene => jfxs}
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafxml.core.{FXMLLoader, NoDependencyResolver}


object MyApp extends JFXApp{
  val rootResource = getClass.getResource(("view/RootLayout.fxml"))
  val loader = new FXMLLoader(rootResource, NoDependencyResolver)
  loader.load();
  val roots = loader.getRoot[jfxs.layout.BorderPane]

  //initialize stage
  stage = new PrimaryStage {
    title = "Roti Maker"
    scene = new Scene {
      root = roots
    }
  }

  def showHomePage(): Unit = {
    val resource = getClass.getResource("view/Home.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load();
    val homePage = loader.getRoot[jfxs.layout.AnchorPane]
    //val control = loader.getController[HomeController#Controller]
    this.roots.setCenter(homePage)

  }
  def showGamePage(): Unit = {
    val resource = getClass.getResource("view/Game.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val gamePage = loader.getRoot[jfxs.Parent]
    //val control = loader.getController[GameController#Controller]
    this.roots.setCenter(gamePage)
  }
//
//  def showScorePage(): Unit = {
//    val resource = getClass.getResource("view/ScoreBoard.fxml")
//    val loader = new FXMLLoader(resource, NoDependencyResolver)
//    loader.load()
//    val scorePage = loader.getRoot[jfxs.layout.Pane]
//    val contentPane = roots.lookup("#contentPane").asInstanceOf[StackPane]
//    contentPane.getChildren.clear()
//    contentPane.getChildren.add(scorePage)
//  }
  // call to display HomePage when app start
  showHomePage()
}