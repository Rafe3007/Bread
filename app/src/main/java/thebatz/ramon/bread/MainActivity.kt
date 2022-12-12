package thebatz.ramon.bread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.*
import android.view.WindowManager
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout

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
    }
}
