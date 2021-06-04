package com.example.test_sportpro.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.test_sportpro.R

class SplashScreenActivity : AppCompatActivity() {
    private var TIME_OUT:Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        loadSplashScreen()
    }

    private fun loadSplashScreen(){
        val image = findViewById<ImageView>(R.id.logo_image)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        Handler(Looper.getMainLooper()).postDelayed({
            image.visibility = View.INVISIBLE
            progressBar.visibility = View.VISIBLE
            
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },TIME_OUT)
    }


}