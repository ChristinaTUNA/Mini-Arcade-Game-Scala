package xy.christina.game.model

case class Ingredient(ingredientName: String, quantity: Int)

trait RecipeType {
  def recipeName: String
  def ingredients: List[Ingredient]
}

case object Bread extends RecipeType {
  def recipeName = "Bread"
  def ingredients: List[Ingredient] = List(Ingredient("Flour", 2), Ingredient("Butter", 1))
}

case object Cake extends RecipeType {
  def recipeName = "Cake"
  def ingredients: List[Ingredient] = List(Ingredient("Flour", 1), Ingredient("Egg", 1), Ingredient("Butter", 1), Ingredient("Strawberry", 2))
}

case object EggTart extends RecipeType {
  def recipeName = "Egg Tart"
  def ingredients: List[Ingredient] = List(Ingredient("Flour", 1), Ingredient("Egg", 2), Ingredient("Milk", 1))
}

case object SwissRoll extends RecipeType {
  def recipeName = "Swiss Roll"
  def ingredients: List[Ingredient] = List(Ingredient("Flour", 1), Ingredient("Cream", 1), Ingredient("Strawberry", 1), Ingredient("Blueberry", 1))
}

case object BlueberryPie extends RecipeType {
  def recipeName = "Pie"
  def ingredients: List[Ingredient] = List(Ingredient("Flour", 1), Ingredient("Cream", 1), Ingredient("Blueberry", 2))
}

case object ChocoCake extends RecipeType {
  def recipeName = "Choco Cake"
  def ingredients: List[Ingredient] = List(Ingredient("Flour", 1), Ingredient("Egg", 2), Ingredient("Butter", 1), Ingredient("Chocolate", 1))
}

case object Baguette extends RecipeType {
  def recipeName = "Baguette"
  def ingredients: List[Ingredient] = List(Ingredient("Flour", 2), Ingredient("Butter", 2))
}

case object Bagel extends RecipeType {
  def recipeName = "Bagel"
  def ingredients: List[Ingredient] = List(Ingredient("Flour", 2), Ingredient("Butter", 1), Ingredient("Egg", 1))
}
