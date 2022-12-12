package thebatz.ramon.bread.Entity

import android.util.Log

class BreadType (name:String, ingredients: Array<Ingredient>, weights: Array<Int>) {
    // Helper
    // https://www.techiedelight.com/add-new-element-array-kotlin/

    // Arrays must be same size
    val name:String = name
    val ingredients:Array<Ingredient> = ingredients
    val weights:Array<Int> = weights
    val breadData = hashMapOf<Ingredient, Int>()

    init {
        if(weights.size != ingredients.size) {
            Log.i("DEBUG", "Ingredients and weights are not of same size!")
        }

        for(i in 0 until ingredients.size) {
            breadData.put(ingredients[i], weights[i])
        }
    }
}