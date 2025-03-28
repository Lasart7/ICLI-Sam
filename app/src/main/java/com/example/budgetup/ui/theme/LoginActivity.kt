package com.example.budgetup.ui.theme

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.budgetup.MainActivity
import com.example.budgetup.R
import com.example.budgetup.SignUpActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Login Button Click Handler
        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            val username = findViewById<EditText>(R.id.etUsername).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()

            when {
                username.isEmpty() -> showError("Username cannot be empty")
                password.isEmpty() -> showError("Password cannot be empty")
                !authenticateUser(username, password) -> showError("Invalid credentials")
                else -> navigateToMain()
            }
        }

        // Sign Up Button Click Handler
        findViewById<Button>(R.id.btnSignUp).setOnClickListener {
            navigateToSignUp()
        }
    }

    private fun authenticateUser(username: String, password: String): Boolean {
        // TODO: Replace with actual authentication logic
        return username == "admin" && password == "password" // Temporary mock
    }

    private fun navigateToMain() {
        Intent(this, MainActivity::class.java).apply {
            putExtra("USERNAME", findViewById<EditText>(R.id.etUsername).text.toString())
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(this)
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }

    private fun navigateToSignUp() {
        startActivity(Intent(this, SignUpActivity::class.java))
        overridePendingTransition(R.anim.slide_in_up, R.anim.fade_out)
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        findViewById<EditText>(R.id.etPassword).apply {
            text.clear()
            requestFocus()
        }
    }
}