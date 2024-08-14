package xy.christina.game.model

class Lives(private var count: Int = 3) {

  def loseLife(): Unit = {
    if (count > 0) count -= 1
  }

  def getLives: Int = count

  def isDead: Boolean = count <= 0

  override def toString: String = s"Lives: $count"
}
