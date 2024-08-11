package xy.christina.game.model

case class Ingredient(name: String, quantity: Int)

trait RecipeType {
  def name: String
  def ingredients: List[Ingredient]
}

case object Bread extends RecipeType {
  val name = "Bread"
  val ingredients = List(Ingredient("Flour", 2), Ingredient("Butter", 1))
}

case object Cake extends RecipeType {
  val name = "Cake"
  val ingredients = List(Ingredient("Flour", 1), Ingredient("Egg", 1), Ingredient("Butter", 1), Ingredient("Strawberry", 2))
}

case object EggTart extends RecipeType {
  val name = "Egg Tart"
  val ingredients = List(Ingredient("Flour", 1), Ingredient("Egg", 2), Ingredient("Milk", 1))
}

case object SwissRoll extends RecipeType {
  val name = "Swiss Roll"
  val ingredients = List(Ingredient("Flour", 1), Ingredient("Cream", 1), Ingredient("Strawberry", 1), Ingredient("Blueberry", 1))
}

case object BlueberryPie extends RecipeType {
  val name = "Pie"
  val ingredients = List(Ingredient("Flour", 1), Ingredient("Cream", 1), Ingredient("Blueberry", 2))
}

case object ChocoCake extends RecipeType {
  val name = "Choco Cake"
  val ingredients = List(Ingredient("Flour", 1), Ingredient("Egg", 2), Ingredient("Butter", 1), Ingredient("Chocolate", 1))
}

case object Baguette extends RecipeType {
  val name = "Baguette"
  val ingredients = List(Ingredient("Flour", 2), Ingredient("Butter", 2))
}

case object Bagel extends RecipeType {
  val name = "Bagel"
  val ingredients = List(Ingredient("Flour", 2), Ingredient("Butter", 1), Ingredient("Egg", 1))
}
