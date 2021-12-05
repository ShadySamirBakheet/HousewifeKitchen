package com.shady.housewifekitchen.views.meal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shady.housewifekitchen.databinding.ActivityRatingMealBinding
import com.shady.housewifekitchen.databinding.ActivityViewMealDetailsBinding
import com.shady.housewifekitchen.utils.Methods
import com.shady.housewifekitchen.views.order.CartViewActivity

class RatingMealActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRatingMealBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRatingMealBinding.inflate(layoutInflater)
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

    }
}