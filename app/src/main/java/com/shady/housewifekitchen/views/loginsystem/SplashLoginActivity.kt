package com.shady.housewifekitchen.views.loginsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.adapters.slider.AppInfoSliderAdapter
import com.shady.housewifekitchen.databinding.ActivityHomeBinding
import com.shady.housewifekitchen.databinding.ActivitySplashLoginBinding
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class SplashLoginActivity : AppCompatActivity() {

    private lateinit var imageSlider: SliderView
    private  var adapter:AppInfoSliderAdapter ?= null
    private lateinit var binding: ActivitySplashLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        imageSlider = binding.imageSlider

        imageSlider.setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)
        imageSlider.setSliderAnimationDuration(1000)
        imageSlider.autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
        imageSlider.scrollTimeInSec = 3
        imageSlider.setIndicatorAnimation(IndicatorAnimationType.DROP)
        imageSlider.startAutoCycle()

        adapter = AppInfoSliderAdapter(this)
        imageSlider.setSliderAdapter(adapter!!)

        Toast.makeText(this, "${adapter!!.count - 1} size", Toast.LENGTH_SHORT).show()

        binding.btnLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
            finish()
        }

        /*imageSlider.setCurrentPageListener {
            if (imageSlider.currentPagePosition == (adapter!!.count-1)){
                startActivity(Intent(this, SplashLogin2Activity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
                finish()
            }
        }*/

    }

    override fun onPause() {
        adapter = null
        super.onPause()
    }

}