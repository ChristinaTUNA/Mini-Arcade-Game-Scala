package xy.christina.game.model

class Score(private var points: Int = 0) {

  def addPoints(amount: Int): Unit = {
    points += amount
  }

  def getPoints: Int = points

  override def toString: String = s"Score: $points"
}
