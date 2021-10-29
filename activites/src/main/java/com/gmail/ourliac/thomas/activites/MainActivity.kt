package com.gmail.ourliac.thomas.activites

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gmail.ourliac.thomas.activites.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            btnClickMe.setOnClickListener(this@MainActivity)
            btnCompute.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_click_me -> {
                nbClick++
                binding.textView.text = getString(R.string.you_click_me, nbClick)
                binding.btnClickMe.isEnabled = nbClick <= 4
            }
            R.id.btn_compute -> {
                val intent = Intent(baseContext, ComputeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
