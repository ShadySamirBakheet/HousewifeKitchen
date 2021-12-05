package com.shady.housewifekitchen.views.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.views.loginsystem.LoginActivity
import com.shady.housewifekitchen.views.loginsystem.SplashLoginActivity
import com.shady.housewifekitchen.views.loginsystem.UserUpdateActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAnimation()
        Handler().postDelayed({
            startActivity(Intent(this, SplashLoginActivity::class.java))
            finish()
        },2000)

    }


    private fun setAnimation() {
        val container = findViewById<ImageView>(R.id.startImg)
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.in_right)
        animation.duration = 2000
        container.startAnimation(animation)
    }

}