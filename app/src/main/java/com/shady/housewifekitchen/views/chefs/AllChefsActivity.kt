package com.shady.housewifekitchen.views.chefs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.adapters.data.chefs.ChefViewAdapter
import com.shady.housewifekitchen.adapters.data.meals.HomeLongMealAdapter
import com.shady.housewifekitchen.databinding.ActivityAllChefsBinding
import com.shady.housewifekitchen.databinding.ActivityViewChefInfoBinding
import com.shady.housewifekitchen.utils.Methods
import com.shady.housewifekitchen.views.order.CartViewActivity

class AllChefsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllChefsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllChefsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goCart.setOnClickListener {
            startActivity(Intent(this, CartViewActivity::class.java))
        }

        binding.goMore.setOnClickListener {
            Methods.showMenu(this)
        }

        binding.goBack.setOnClickListener {
           finish()
        }

        binding.chefsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = ChefViewAdapter(context)
        }

    }
}