package xy.christina.game.model

class Game (player: Player){
  var isRunning: Boolean = false

  def start(): ={
    isRunning = true
  }

  def stop(): Unit = {
    isRunning = false
  }

  def update(): ={

  }
}
