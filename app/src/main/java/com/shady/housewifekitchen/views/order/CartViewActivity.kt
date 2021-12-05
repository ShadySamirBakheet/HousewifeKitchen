package com.shady.housewifekitchen.views.order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.adapters.data.meals.HomeMoreMealAdapter
import com.shady.housewifekitchen.adapters.data.orders.CartAdapter
import com.shady.housewifekitchen.adapters.data.orders.CartItemAdapter
import com.shady.housewifekitchen.databinding.ActivityCartViewBinding
import com.shady.housewifekitchen.databinding.ActivitySearchBinding
import com.shady.housewifekitchen.utils.Methods

class CartViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCartViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goMore.setOnClickListener {
            Methods.showMenu(this)
        }

        binding.goBack.setOnClickListener {
            finish()
        }

        binding.cartList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CartAdapter(context)
        }

    }
}