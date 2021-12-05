package com.shady.housewifekitchen.views.loginsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shady.housewifekitchen.databinding.ActivityConfirmCodeBinding
import com.shady.housewifekitchen.databinding.ActivityForgetPasswordBinding

class ForgetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}