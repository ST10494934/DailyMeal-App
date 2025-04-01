package za.ac.iie.dailymealapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // UI Elements
        val edtTimeOfDay = findViewById<EditText>(R.id.edtTimeOfDay)
        val txtMealSuggestion = findViewById<TextView>(R.id.txtMealSuggestion)
        val btnSuggestMeal = findViewById<Button>(R.id.btnSuggestMeal)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnFoodBattle = findViewById<Button>(R.id.btnFoodBattle)
        val txtBattleResult = findViewById<TextView>(R.id.txtBattleResult)

        // Button Click Listener for Meal Suggestion
        btnSuggestMeal.setOnClickListener {
            val timeOfDay = edtTimeOfDay.text.toString().trim().lowercase()

            // Meal Suggestion Logic
            val mealSuggestion = when (timeOfDay) {
                "morning" -> "🥞 Pancakes"
                "mid-morning" -> "🥗 Fresh Fruits"
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
            txtBattleResult.text = ""  // Also clear food battle result
            Log.d("MealSuggestion", "Reset button clicked - Input cleared")
        }

        // Food Battle Mini-Game
        btnFoodBattle.setOnClickListener {
            val foods = listOf("🍕 Pizza", "🥗 Salad", "🍔 Burger", "🍣 Sushi", "🌮 Taco", "🍩 Donut")
            val food1 = foods[Random.nextInt(foods.size)]
            val food2 = foods[Random.nextInt(foods.size)]

            val winner = if (Random.nextBoolean()) food1 else food2

            txtBattleResult.text = "Food Battle: $food1 vs. $food2 \n Winner: $winner! 🏆"
            Log.d("FoodBattle", "Food Battle: $food1 vs. $food2, Winner: $winner")
        }
    }
}