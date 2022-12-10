package thebatz.ramon.bread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mixingBowlButton = findViewById<ImageButton>(R.id.MixingBowlButton)

        // Layouts
        val bowlContentView = findViewById<FrameLayout>(R.id.BowlContentLayout)
        val BC_BackButton = findViewById<Button>(R.id.BowlContentBackButton)

        mixingBowlButton.setOnClickListener {
            bowlContentView.visibility = VISIBLE
        }
        BC_BackButton.setOnClickListener {
            bowlContentView.visibility = INVISIBLE
        }
    }
}
