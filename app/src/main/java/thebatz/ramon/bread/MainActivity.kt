package thebatz.ramon.bread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.*
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import thebatz.ramon.bread.Entity.BreadType
import thebatz.ramon.bread.Entity.Ingredient

class MainActivity : AppCompatActivity() {

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

        // Recipe book
        val recipeBackButton = findViewById<Button>(R.id.recipeBackButton)
        val recipeBookButton = findViewById<ImageButton>(R.id.RecipeBookButton)
        recipeBookButton.setOnClickListener {
            recipeBook.visibility = VISIBLE
        }
        recipeBackButton.setOnClickListener {
            recipeBook.visibility = GONE
        }

    // ---======[Game Logic]======---
        // Bread Types
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
        for(i in 0..whiteIngredientsLayout.childCount-1) {
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
