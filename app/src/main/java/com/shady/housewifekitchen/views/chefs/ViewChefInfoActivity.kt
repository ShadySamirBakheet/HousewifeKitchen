package com.shady.housewifekitchen.views.chefs

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.adapters.data.meals.HomeLongMealAdapter
import com.shady.housewifekitchen.adapters.data.meals.HomeOffersMealAdapter
import com.shady.housewifekitchen.adapters.slider.SliderHomeAdapter
import com.shady.housewifekitchen.databinding.ActivityViewChefInfoBinding
import com.shady.housewifekitchen.databinding.ActivityViewMealDetailsBinding
import com.shady.housewifekitchen.utils.Methods
import com.shady.housewifekitchen.views.order.CartViewActivity
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class ViewChefInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewChefInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewChefInfoBinding.inflate(layoutInflater)
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

        binding.imageSlider.apply {
            setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)
            setSliderAnimationDuration(1000)
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
            scrollTimeInSec = 4 //set scroll delay in seconds :
            startAutoCycle()
            setSliderAdapter(SliderHomeAdapter(context))
        }

        binding.fastMealList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter = HomeOffersMealAdapter(context)
        }

        binding.longMealList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = HomeLongMealAdapter(context)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.conMain.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                if (scrollY >= oldScrollY || scrollY > 0) {
                    if (scrollY > 0){
                        binding.backCon.alpha = (scrollY.toFloat()/500f)
                    }
                } else {
                    binding.backCon.alpha = 0f
                }
            }
        }else{
            binding.backCon.alpha = 1f
        }

    }
}