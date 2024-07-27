package xy.christina.game.view

import scalafxml.core.macros.sfxml
import xy.christina.game.model.{Game, Player}

@sfxml
class GameController {
  val player = Player("Player",0)
  val game = new Game(player)

//  def initialize(): ={
//    game.start()
//  }
}
