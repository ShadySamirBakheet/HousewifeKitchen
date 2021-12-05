package com.shady.housewifekitchen.views.loginsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.codeCountry.adapter = ArrayAdapter(this, R.layout.item_spinner, arrayOf("Eg +20","Eg +20","Eg +20",))
        binding.state.adapter = ArrayAdapter(this, R.layout.item_spinner, arrayOf("State ","State ","State ",))
        binding.area.adapter = ArrayAdapter(this, R.layout.item_spinner, arrayOf("Area","Area","Area",))

    }
}