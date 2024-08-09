package xy.christina.game.model

class Player(val name: String) {
  val score = new Score()
  val lives = new Lives()

  def reset(): Unit = {
    score.reset()
    lives.reset()
  }

  override def toString: String = s"Player: $name, ${score.toString}, ${lives.toString}"
}
