package thebatz.ramon.bread

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.*
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import thebatz.ramon.bread.Entity.Bowl
import thebatz.ramon.bread.Entity.BreadType
import thebatz.ramon.bread.Entity.Ingredient

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Layouts
        val bowlContentView = findViewById<ConstraintLayout>(R.id.BowlContentLayout)
        val recipeBook = findViewById<ConstraintLayout>(R.id.RecipeLayout)
        bowlContentView.visibility = GONE
        recipeBook.visibility = GONE

        // Mixing Bowl
        val mixingBowlButton = findViewById<ImageButton>(R.id.MixingBowlButton)
        val BC_BackButton = findViewById<Button>(R.id.BowlContentBackButton)
        mixingBowlButton.setOnClickListener {
            bowlContentView.visibility = VISIBLE
        }
        BC_BackButton.setOnClickListener {
            bowlContentView.visibility = GONE
        }

        val allowedIng:Array<Ingredient> = arrayOf(
            Ingredient.BREADFLOUR,
            Ingredient.WHEATFLOUR,
            Ingredient.SALT,
            Ingredient.WATER,
            Ingredient.YEAST
        )
        val bowl = Bowl(0, allowedIng)
        val scaleLayout = findViewById<LinearLayout>(R.id.scaleLayout)
        fun updateScale() {
            for(i in 0 until bowl.allowedIngredients.size) {
                val v = scaleLayout[i]
                val tv = findViewById<TextView>(v.id)
                val txt = bowl.getWeightString(bowl.allowedIngredients[i])
                tv.text = txt
            }
        }
        updateScale() // Initial update

        // Recipe book
        val recipeBackButton = findViewById<Button>(R.id.recipeBackButton)
        val recipeBookButton = findViewById<ImageButton>(R.id.RecipeBookButton)
        recipeBookButton.setOnClickListener {
            recipeBook.visibility = VISIBLE
        }
        recipeBackButton.setOnClickListener {
            recipeBook.visibility = GONE
        }

        val whiteLoafIngredients:Array<Ingredient> = arrayOf(
            Ingredient.BREADFLOUR,
            Ingredient.YEAST,
            Ingredient.SALT,
            Ingredient.WATER
        )
        val whiteLoafWeight:Array<Int> = arrayOf(
            500,
            5,
            16,
            360
        )
        val whiteLoaf = BreadType("White Loaf", whiteLoafIngredients, whiteLoafWeight)
        val whiteIngredientsLayout = findViewById<LinearLayout>(R.id.recipeWhiteLayout)
        for(i in 0 until whiteIngredientsLayout.childCount) {
            val v = whiteIngredientsLayout[i]
            val tv = findViewById<TextView>(v.id)
            tv.text = "${whiteLoaf.weights[i].toString()} g of ${whiteLoaf.ingredients[i].displayName}"
        }

        val wheatLoafIngredients:Array<Ingredient> = arrayOf(
            Ingredient.WHEATFLOUR,
            Ingredient.YEAST,
            Ingredient.SALT,
            Ingredient.WATER
        )
        val wheatLoafWeight:Array<Int> = arrayOf(
            500,
            5,
            16,
            360
        )
        val wheatLoaf = BreadType("Wheat Loaf", wheatLoafIngredients, wheatLoafWeight)
        val wheatIngredientsLayout = findViewById<LinearLayout>(R.id.recipeWheatLayout)
        for(i in 0..wheatIngredientsLayout.childCount-1) {
            val v = wheatIngredientsLayout[i]
            val tv = findViewById<TextView>(v.id)
            tv.text = "${wheatLoaf.weights[i].toString()} g of ${wheatLoaf.ingredients[i].displayName}"
        }

        

    }
}
