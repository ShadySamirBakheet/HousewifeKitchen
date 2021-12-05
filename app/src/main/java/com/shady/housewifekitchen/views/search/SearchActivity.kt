package com.shady.housewifekitchen.views.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.adapters.data.category.SearchMeaTypelAdapter
import com.shady.housewifekitchen.adapters.data.meals.SearchMealAdapter
import com.shady.housewifekitchen.databinding.ActivitySearchBinding
import com.shady.housewifekitchen.utils.Methods
import com.shady.housewifekitchen.views.order.CartViewActivity

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
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

        binding.goLocation.setOnClickListener {
            startActivity(Intent(this,LocationSearchActivity::class.java))
        }

        binding.mealList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter = SearchMeaTypelAdapter(context)
        }

        binding.searchList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = SearchMealAdapter(context)
        }

    }
}