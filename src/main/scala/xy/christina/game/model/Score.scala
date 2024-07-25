package xy.christina.game.model

import scala.collection.mutable

object Score {
  private val scores: mutable.Buffer[(String, Int)] = mutable.Buffer()

  def addScore(player: Player): Unit = {
    scores.append((player.name, player.score))
  }

  def getScores: Seq[(String, Int)] = scores.toSeq
}
