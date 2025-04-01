package za.ac.iie.dailymealapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI Elements
        val edtTimeOfDay = findViewById<EditText>(R.id.edtTimeOfDay)
        val txtMealSuggestion = findViewById<TextView>(R.id.txtMealSuggestion)
        val btnSuggestMeal = findViewById<Button>(R.id.btnSuggestMeal)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val txtTimeOfDayPrompt = findViewById<TextView>(R.id.txtTimeOfDayPrompt)

        // Button Click Listener for Meal Suggestion
        btnSuggestMeal.setOnClickListener {
            val timeOfDay = edtTimeOfDay.text.toString().trim().lowercase()

            // Meal Suggestion Logic
            val mealSuggestion = when (timeOfDay) {
                "morning" -> "🥞 Pancakes"
                "mid-morning" -> "🥗 Fresh Fruits "
                "afternoon" -> "🥪 Chicken Sandwich"
                "mid-afternoon" -> "🍰 A Slice of Cake"
                "dinner" -> "🍝 Pasta"
                "after dinner snack" -> "🍨 Ice Cream"
                else -> "⚠️ Invalid entry! Please enter: Morning, Mid-morning, Afternoon, Mid-afternoon, Dinner, or After Dinner Snack."
            }

            // Display the Result/Output
            txtMealSuggestion.text = mealSuggestion
            Log.d("MealSuggestion", "User entered: $timeOfDay, Suggested meal: $mealSuggestion")
        }

        // Reset Button
        btnReset.setOnClickListener {
            edtTimeOfDay.text.clear()
            txtMealSuggestion.text = ""
            Log.d("MealSuggestion", "Reset button clicked - Input cleared")
        }
    }
}