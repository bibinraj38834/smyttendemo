package com.example.smyttendemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            // Delay for 5 seconds
            kotlinx.coroutines.delay(5000)

            // Show dialog on the main thread
            Handler(Looper.getMainLooper()).post {
                showCustomDialog()
            }
        }
    }

    private fun showCustomDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null)

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialogTitle)
        val dialogMessage = dialogView.findViewById<TextView>(R.id.dialogMessage)
        val dialogButton = dialogView.findViewById<Button>(R.id.dialogButton)

        val alertDialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(false)
            .create()

        dialogTitle.text = "Smytten"
        dialogMessage.text = "Hello!"

        dialogButton.setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}