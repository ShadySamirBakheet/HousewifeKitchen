package com.shady.housewifekitchen.views.loginsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.databinding.ActivityLoginBinding
import com.shady.housewifekitchen.databinding.ActivitySplashLogin2Binding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goSignUp.setOnClickListener {
            startActivity(
                Intent(this, SignupActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TASK))
            finish()
        }

    }
}