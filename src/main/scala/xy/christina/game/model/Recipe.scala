package xy.christina.game.model

case class Recipe(name: String, ingredients: List[(String, Int)])

object Recipe {
  val Bread = Recipe("Bread", List(("Flour", 2), ("Butter", 1)))
  val Cake = Recipe("Cake", List(("Flour", 1), ("Egg", 2), ("Butter", 1)))
  val EggTart = Recipe("Egg Tart", List(("Flour", 1), ("Egg", 1), ("Milk", 1)))

  val allRecipes = List(Bread, Cake, EggTart)
}
