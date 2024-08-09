package xy.christina.game.model

case class Ingredient(name: String, quantity: Int)

case class Recipe(name: String, ingredients: List[Ingredient])

object Recipe {
  val Bread = Recipe("Bread", List(Ingredient("Flour", 2), Ingredient("Butter", 1)))
  val Cake = Recipe("Cake", List(Ingredient("Flour", 1), Ingredient("Egg", 1), Ingredient("Butter", 1), Ingredient("Strawberry", 2)))
  val EggTart = Recipe("Egg Tart", List(Ingredient("Flour", 1), Ingredient("Egg", 2), Ingredient("Milk", 1)))
  val SwissRoll = Recipe("Swiss Roll",  List(Ingredient("Flour", 1), Ingredient("Cream", 1), Ingredient("Strawberry", 1), Ingredient("Blueberry", 1)))
  val BlueberryPie = Recipe("Pie",  List(Ingredient("Flour", 1), Ingredient("Cream", 1), Ingredient("Blueberry", 2), Ingredient("Egg", 1)))
  val ChocoCake = Recipe("Choco Cake", List(Ingredient("Flour", 1), Ingredient("Egg", 2), Ingredient("Butter", 1), Ingredient("Chocolate", 1)))
  val Baguette = Recipe("Baguette", List(Ingredient("Flour", 2), Ingredient("Butter", 2)))
  val Bagel = Recipe("Bagel", List(Ingredient("Flour", 2), Ingredient("Butter", 1), Ingredient("Egg", 1)))

  val allRecipes = List(Bread, Cake, EggTart, SwissRoll, ChocoCake, Baguette, BlueberryPie, Bagel)
}
