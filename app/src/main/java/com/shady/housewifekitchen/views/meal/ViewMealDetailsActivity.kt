package com.shady.housewifekitchen.views.meal

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.adapters.data.meals.MealContentAdapter
import com.shady.housewifekitchen.adapters.data.meals.MealExtraAdapter
import com.shady.housewifekitchen.adapters.slider.SliderMealAdapter
import com.shady.housewifekitchen.databinding.ActivityViewMealDetailsBinding
import com.shady.housewifekitchen.utils.Methods
import com.shady.housewifekitchen.views.chefs.ViewChefInfoActivity
import com.shady.housewifekitchen.views.order.CartViewActivity
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class ViewMealDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewMealDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewMealDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goCart.setOnClickListener {
            startActivity(Intent(this, CartViewActivity::class.java))
        }

        binding.chefInfo.setOnClickListener {
            startActivity(Intent(this, ViewChefInfoActivity::class.java))
        }

        binding.addComment.setOnClickListener {
            startActivity(Intent(this, RatingMealActivity::class.java))
        }

        binding.goMore.setOnClickListener {
            Methods.showMenu(this)
        }

        binding.goBack.setOnClickListener {
            finish()
        }

        binding.listContent.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = MealContentAdapter(context)
        }

        binding.listExtras.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = MealExtraAdapter(context)
        }

        binding.imageSlider.apply {
            setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)
            setSliderAnimationDuration(1000)
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
            scrollTimeInSec = 4 //set scroll delay in seconds :
            startAutoCycle()
            setSliderAdapter(SliderMealAdapter(context))
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