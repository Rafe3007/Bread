package thebatz.ramon.bread.Entity

import android.util.Log

class BreadType (name:String, ingredients: Array<Ingredient>, weights: Array<Int>) {
    // Arrays must be same size
    val name:String = name
    val ingredients:Array<Ingredient> = ingredients
    val weights:Array<Int> = weights

    init {
        if(weights.size != ingredients.size) {
            Log.i("DEBUG", "Ingredients and weights are not of same size!")
        }
    }
}