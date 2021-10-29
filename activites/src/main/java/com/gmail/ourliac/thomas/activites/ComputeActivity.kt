package com.gmail.ourliac.thomas.activites

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity(), TextWatcher {
    private lateinit var calculButton: Button
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var resultat: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        calculButton = findViewById(R.id.btn_calculer)
        editText1 = findViewById(R.id.field_1)
        editText2 = findViewById(R.id.field_2)
        resultat = findViewById(R.id.resultat)
        calculButton.isEnabled = false

        editText1.addTextChangedListener(this)
        editText2.addTextChangedListener(this)

        calculButton.setOnClickListener {
            val nb1 = editText1.text.toString().toDouble()
            val nb2 = editText2.text.toString().toDouble()
            val nb3 = nb1 + nb2
            resultat.text = nb3.toString()
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        calculButton.isEnabled = editText1.text.isNotEmpty() && editText2.text.isNotEmpty()
    }
}
