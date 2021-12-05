package com.shady.housewifekitchen.views.loginsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shady.housewifekitchen.databinding.ActivityChangePasswordBinding
import com.shady.housewifekitchen.databinding.ActivityForgetPasswordBinding

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}