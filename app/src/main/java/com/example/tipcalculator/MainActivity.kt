package com.example.tipcalculator

import android.os.Bundle
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

        calculateButton.setOnClickListener { calculateTip() }
    }

    private fun calculateTip() {
        val bill = billAmount.text.toString().toDoubleOrNull() ?: 0.0
        val tipPercent = tipPercentage.text.toString().toDoubleOrNull() ?: 0.0

        val tip = bill * (tipPercent / 100)
        val total = bill + tip

        tipAmount.text = "Tip Amount: ${String.format("%.2f", tip)}"
        totalAmount.text = "Total Amount: ${String.format("%.2f", total)}"
    }
}