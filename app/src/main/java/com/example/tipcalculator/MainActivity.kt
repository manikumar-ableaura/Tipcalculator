package com.example.tipcalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var billAmount: EditText
    private lateinit var tipPercentage: EditText
    private lateinit var calculateButton: Button
    private lateinit var tipAmount: TextView
    private lateinit var totalAmount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        billAmount = findViewById(R.id.billAmount)
        tipPercentage = findViewById(R.id.tipPercentage)
        calculateButton = findViewById(R.id.calculateButton)
        tipAmount = findViewById(R.id.tipAmount)
        totalAmount = findViewById(R.id.totalAmount)

        // Initially hide the tipAmount and totalAmount TextViews
        tipAmount.visibility = View.GONE
        totalAmount.visibility = View.GONE

        // Set up the button click listener
        calculateButton.setOnClickListener {
            if (calculateButton.text == "Calculate Tip") {
                // Calculate the tip and total amount
                val bill = billAmount.text.toString().toDoubleOrNull() ?: 0.0
                val tipPercent = tipPercentage.text.toString().toDoubleOrNull() ?: 0.0

                val tip = bill * (tipPercent / 100)
                val total = bill + tip

                // Display the calculated values
                tipAmount.text = "Tip Amount: ${String.format("%.2f", tip)}"
                totalAmount.text = "Total Amount: ${String.format("%.2f", total)}"

                // Show the TextViews
                tipAmount.visibility = View.VISIBLE
                totalAmount.visibility = View.VISIBLE

                // Change button text to "Clear"
                calculateButton.text = "Clear"
            } else {
                // Clear all fields
                billAmount.text.clear()
                tipPercentage.text.clear()
                tipAmount.visibility = View.GONE
                totalAmount.visibility = View.GONE

                // Change button text back to "Calculate Tip"
                calculateButton.text = "Calculate Tip"
            }
        }
    }
}
