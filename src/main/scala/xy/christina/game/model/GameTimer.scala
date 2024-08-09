package xy.christina.game.model

class GameTimer(private var timeLimit: Int) {
  private var timeRemaining = timeLimit
  private var isRunning = true

  def pause(): Unit = {
    isRunning = false
  }

  def reset(): Unit = {
    timeRemaining = timeLimit
  }

  def tick(): Unit = {
    if (isRunning && timeRemaining > 0) {
      timeRemaining -= 1
    }
  }

  def getTimeRemaining: Int = timeRemaining

  def isTimeUp: Boolean = timeRemaining <= 0

  def isTimerRunning: Boolean = isRunning
}
