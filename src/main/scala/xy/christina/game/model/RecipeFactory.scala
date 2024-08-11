package xy.christina.game.model

import scala.util.Random

object RecipeFactory {

  private val allRecipes: List[RecipeType] = List(Bread, Cake, EggTart, SwissRoll, ChocoCake, Baguette, BlueberryPie, Bagel)

  def createRandomRecipe(): RecipeType = {
    val randomIndex = Random.nextInt(allRecipes.size)
    allRecipes(randomIndex)
  }
}
