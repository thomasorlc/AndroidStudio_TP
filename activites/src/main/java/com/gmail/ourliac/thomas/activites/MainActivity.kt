package com.gmail.ourliac.thomas.activites

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var clickButton: Button
    private lateinit var textView: TextView
    private lateinit var computeButton: Button
    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.btn_click_me)
        computeButton = findViewById(R.id.btn_compute)
        textView = findViewById(R.id.text_view)

        computeButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }

        clickButton.setOnClickListener {
            nbClick++
            textView.text = "Vous avez cliqué $nbClick fois"
            clickButton.isEnabled = nbClick <= 4
        }
    }

}
