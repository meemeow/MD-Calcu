package com.example.ezcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val outputBox: TextView = findViewById(R.id.output_box)
        val firstNum: EditText = findViewById(R.id.edittext_first_number)
        val secondNum: EditText = findViewById(R.id.edittext_second_number)
        val addButton: Button = findViewById(R.id.button_add)
        val subtractButton: Button = findViewById(R.id.button_subtract)
        val multiplyButton: Button = findViewById(R.id.button_multiply)
        val divideButton: Button = findViewById(R.id.button_divide)

        addButton.setOnClickListener {
            operations(firstNum, secondNum, outputBox, "add")
        }

        subtractButton.setOnClickListener {
            operations(secondNum, firstNum, outputBox, "subtract")
        }

        multiplyButton.setOnClickListener {
            operations(firstNum, secondNum, outputBox, "multiply")
        }

        divideButton.setOnClickListener {
            operations(firstNum, secondNum, outputBox, "divide")
        }
    }

    private fun operations(firstNum: EditText, secondNum: EditText, outputBox: TextView, operation: String) {
        val num1 = firstNum.text.toString().toDoubleOrNull()
        val num2 = secondNum.text.toString().toDoubleOrNull()

        if (num1 != null && num2 != null) {
            val result = when (operation) {
                "add" -> num1 + num2
                "subtract" -> num1 - num2
                "multiply" -> num1 * num2
                "divide" -> {
                    if (num2 != 0.0) num1 / num2 else {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        return
                    }
                }
                else -> 0.0
            }
            outputBox.text = result.toString()
        } else {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
        }
    }
}
