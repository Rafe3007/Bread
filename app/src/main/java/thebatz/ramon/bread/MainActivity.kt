package thebatz.ramon.bread

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.*
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import androidx.core.view.isVisible
import org.w3c.dom.Text
import thebatz.ramon.bread.Entity.Bowl
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

            val totalScale = findViewById<TextView>(R.id.scaleText)
            totalScale.text = "${bowl.totalWeight} grams"
        }
        updateScale() // Initial update

        val resetBowlButton = findViewById<Button>(R.id.resetBowlButton)
        resetBowlButton.setOnClickListener {
            bowl.resetBowl()
            updateScale()
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
        for(i in 0 until wheatIngredientsLayout.childCount) {
            val v = wheatIngredientsLayout[i]
            val tv = findViewById<TextView>(v.id)
            tv.text = "${wheatLoaf.weights[i].toString()} g of ${wheatLoaf.ingredients[i].displayName}"
        }

        // Buttons
        val breadFlourButton = findViewById<ImageButton>(R.id.imgButtonBreadFlour)
        val wheatFlourButton = findViewById<ImageButton>(R.id.imgButtonWheatFlour)
        val yeastButton = findViewById<ImageButton>(R.id.imgButtonYeast)
        val waterButton = findViewById<ImageButton>(R.id.imgButtonWater)
        val saltButton = findViewById<ImageButton>(R.id.imgButtonSalt)

        breadFlourButton.setOnClickListener {
            bowl.addWeight(Ingredient.BREADFLOUR, 10)
            updateScale()
        }
        wheatFlourButton.setOnClickListener {
            bowl.addWeight(Ingredient.WHEATFLOUR, 10)
            updateScale()
        }
        yeastButton.setOnClickListener {
            bowl.addWeight(Ingredient.YEAST, 1)
            updateScale()
        }
        waterButton.setOnClickListener {
            bowl.addWeight(Ingredient.WATER, 10)
            updateScale()
        }
        saltButton.setOnClickListener {
            bowl.addWeight(Ingredient.SALT, 1)
            updateScale()
        }

    //-----======[Game Logic]======-----
        // TODO: Move Game logic to it's own class
        // Plan to randomize and add higher quantities of breads to make
        // For now, game is testing if only one of the two breads are made
        // if bread is made -> Game Over

        // Needed Game Views
        val gameText = findViewById<TextView>(R.id.gameText)
        val updateUserText = findViewById<TextView>(R.id.updateUserText)
        val mixingButton = findViewById<Button>(R.id.mixIngredientButton)

        var gameEnd = false
        val randBread = (1..2).random()
        val breadObjective:BreadType
        if(randBread == 1) {
            breadObjective = whiteLoaf
            gameText.text = "Make a ${whiteLoaf.name}"
        }
        else { // else ifs for more loafs
            breadObjective = wheatLoaf
            gameText.text = "Make a ${wheatLoaf.name}"
        }

        fun checkGameEnd() {
            if(gameEnd) {
                updateUserText.text = "Yummy!!!"
            } else {
                updateUserText.text = "EW! This is NOT bread..."
            }
        }

        mixingButton.setOnClickListener {
            if(bowlContentView.isVisible) {
                bowlContentView.visibility = GONE
            }
            if(recipeBook.isVisible) {
                recipeBook.visibility = GONE
            }

            val bowlData = bowl.getBowlData()
            if(bowlData.size == breadObjective.breadData.size) {
                for(entry in breadObjective.breadData) {
                    val bowlWeight = bowlData[entry.key]
                    if(entry.value != bowlWeight) {
                        break
                    }
                }
                gameEnd = true
            }

            checkGameEnd()
        }

    }
}
