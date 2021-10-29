package com.gmail.ourliac.thomas.tp1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image_view)
        button = findViewById(R.id.my_button)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val links = listOf(
            "https://www.pngkey.com/png/detail/340-3405814_best-adorable-cat-png-png-baby-cat-png.png",
            "https://i.pinimg.com/originals/22/60/b4/2260b463e2591adee70316d1059955d6.png",
            "https://cdn.freelogovectors.net/wp-content/uploads/2017/05/cat-png-clipart-12.png",
            "https://www.freeiconspng.com/thumbs/cat-png/cat-png-25.png",
            "https://www.pngplay.com/wp-content/uploads/6/Fat-British-Shorthair-Cat-Transparent-File.png"
        )
        loadImage(links.random())
        Toast.makeText(this, "You clicked me", Toast.LENGTH_LONG).show()
    }

    private fun loadImage(url: String) {
        Glide.with(this)
            .load(url)
            .fallback(R.drawable.ic_launcher_background)
            .into(imageView)
    }
}
