package com.shady.housewifekitchen.views.loginsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.databinding.ActivitySplashLogin2Binding
import com.shady.housewifekitchen.databinding.ActivitySplashLoginBinding

class SplashLogin2Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashLogin2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashLogin2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            startActivity(
                Intent(this, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TASK))
            finish()
        }

        Glide.with(this)
            .load("https://media.giphy.com/media/ea33E5ET1Lehl0ByMY/giphy.gif")
            .centerCrop()
            .placeholder(R.drawable.image9)
            .into(binding.image);


    }
}