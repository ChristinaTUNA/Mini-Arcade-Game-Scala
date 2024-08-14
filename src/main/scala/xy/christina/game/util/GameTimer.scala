package xy.christina.game.util

class GameTimer(private var timeLimit: Int) {
  private var timeRemaining = timeLimit


  def resetTime(): Unit = {
    timeRemaining = timeLimit
  }

  def tick(): Unit = {
    if (timeRemaining > 0) {
      timeRemaining -= 1
    }
  }

  def getTimeRemaining: Int = timeRemaining

  def isTimeUp: Boolean = timeRemaining <= 0

}
