package com.shady.housewifekitchen.views.meal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.adapters.data.meals.FavouriteMealAdapter
import com.shady.housewifekitchen.adapters.data.meals.HomeOffersMealAdapter
import com.shady.housewifekitchen.databinding.ActivityMealCategoryBinding
import com.shady.housewifekitchen.utils.Methods
import com.shady.housewifekitchen.views.order.CartViewActivity

class MealCategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMealCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealCategoryBinding.inflate(layoutInflater)
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

        binding.mealList2.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = FavouriteMealAdapter(context)
        }

        binding.mealList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = HomeOffersMealAdapter(context)
        }

    }
}