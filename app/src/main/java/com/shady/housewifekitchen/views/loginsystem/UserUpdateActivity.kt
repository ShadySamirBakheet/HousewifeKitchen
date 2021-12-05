package com.shady.housewifekitchen.views.loginsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.databinding.ActivityConfirmCodeBinding
import com.shady.housewifekitchen.databinding.ActivityUserUpdateBinding

class UserUpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.area.adapter = ArrayAdapter<String>(this, R.layout.item_spinner, arrayOf("Area 1","Area 1","Area 1","Area 1","Area 1","Area 1","Area 1",))

    }
}