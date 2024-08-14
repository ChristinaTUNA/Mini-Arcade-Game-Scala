package xy.christina.game.model

class Player(val name: String) {
  val score = new Score()
  val lives = new Lives()

  override def toString: String = s"Player: $name, ${score.toString}, ${lives.toString}"
}
