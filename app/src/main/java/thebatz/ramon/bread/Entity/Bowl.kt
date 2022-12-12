package thebatz.ramon.bread.Entity

class Bowl(baseWeight:Int, allowedIngredients:Array<Ingredient>) {
    var totalWeight = 0
    val baseWeight:Int = baseWeight
    val allowedIngredients:Array<Ingredient> = allowedIngredients
    var breadFlourWeight:Int = 0
    var wheatFlourWeight:Int = 0
    var saltWeight:Int = 0
    var yeastWeight:Int = 0
    var waterWeight:Int = 0

    fun addWeight(ing:Ingredient, weight:Int) {
        if(ing == Ingredient.BREADFLOUR) {
            breadFlourWeight += weight
        }
        else if(ing == Ingredient.WHEATFLOUR) {
            wheatFlourWeight += weight
        }
        else if(ing == Ingredient.YEAST) {
            saltWeight += weight
        }
        else if(ing == Ingredient.SALT) {
            yeastWeight += weight
        }
        else if(ing == Ingredient.WATER) {
            waterWeight += weight
        }

        totalWeight += weight
    }

    fun getWeightString(ing:Ingredient):String {
        var w = 0
        if(ing == Ingredient.BREADFLOUR) {
            w = breadFlourWeight
        }
        else if(ing == Ingredient.WHEATFLOUR) {
            w = wheatFlourWeight
        }
        else if(ing == Ingredient.YEAST) {
            w = saltWeight
        }
        else if(ing == Ingredient.SALT) {
            w = yeastWeight
        }
        else if(ing == Ingredient.WATER) {
            w = waterWeight
        }

        return "$w grams ${ing.displayName}"
    }

    fun resetBowl() {
        breadFlourWeight = 0
        wheatFlourWeight = 0
        saltWeight = 0
        yeastWeight = 0
        waterWeight = 0
        totalWeight = 0
    }
}