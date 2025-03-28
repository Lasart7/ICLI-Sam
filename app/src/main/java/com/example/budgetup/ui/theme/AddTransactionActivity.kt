package com.example.budgetup.ui.theme

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.budgetup.R

class AddTransactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)

        // Setup category spinner
        val categories = arrayOf("Food", "Social Life", "Pets", "Transport", "Culture",
            "Household", "Apparel", "Beauty", "Health", "Education", "Gift", "Other")
        val categoryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categories)
        findViewById<Spinner>(R.id.spCategory).adapter = categoryAdapter

        // Setup account spinner
        val accounts = arrayOf("Cash", "Bank Account", "Credit Card") // Replace with real accounts
        val accountAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, accounts)
        findViewById<Spinner>(R.id.spAccount).adapter = accountAdapter

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            saveTransaction()
        }
    }

    private fun saveTransaction() {
        // Get all input values and save to database
        val transactionType = when (findViewById<RadioGroup>(R.id.rgTransactionType).checkedRadioButtonId) {
            R.id.rbIncome -> "Income"
            R.id.rbExpense -> "Expense"
            else -> "Transfer"
        }
        val amount = findViewById<EditText>(R.id.etAmount).text.toString().toDoubleOrNull() ?: 0.0
        val category = findViewById<Spinner>(R.id.spCategory).selectedItem.toString()
        val account = findViewById<Spinner>(R.id.spAccount).selectedItem.toString()
        val note = findViewById<EditText>(R.id.etNote).text.toString()
        val description = findViewById<EditText>(R.id.etDescription).text.toString()

        // Save to database and finish or show confirmation
        finish()
    }
}