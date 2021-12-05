package com.shady.housewifekitchen.views.home.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.adapters.data.category.HomeMealAdapter
import com.shady.housewifekitchen.adapters.data.chefs.FavoriteChefHomeAdapter
import com.shady.housewifekitchen.adapters.data.meals.*
import com.shady.housewifekitchen.adapters.data.orders.OrderAgainAdapter
import com.shady.housewifekitchen.adapters.data.videos.HomeVideoAdapter
import com.shady.housewifekitchen.adapters.slider.SliderHomeAdapter
import com.shady.housewifekitchen.databinding.FragmentHomeBinding
import com.shady.housewifekitchen.utils.Methods.Companion.showMenu
import com.shady.housewifekitchen.views.chefs.AllChefsActivity
import com.shady.housewifekitchen.views.order.CartViewActivity
import com.shady.housewifekitchen.views.search.SearchActivity
import com.shady.housewifekitchen.views.videos.VideosActivity
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView

class HomeFragment : Fragment() {

   // private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        binding.goSearch2.setOnClickListener {
            startActivity(Intent(context,SearchActivity::class.java))
        }

        binding.goSearch.setOnClickListener {
            startActivity(Intent(context, SearchActivity::class.java))
        }

        binding.goCart.setOnClickListener {
            startActivity(Intent(context, CartViewActivity::class.java))
        }

        binding.goMore2.setOnClickListener {
            showMenu(requireContext())
        }

        binding.goMore.setOnClickListener {
            showMenu(requireContext())
        }

        binding.goCart2.setOnClickListener {
            startActivity(Intent(context, CartViewActivity::class.java))
        }

        binding.goChefsMeal.setOnClickListener {
            startActivity(Intent(context, AllChefsActivity::class.java))
        }

        binding.goVideosMeal.setOnClickListener {
            startActivity(Intent(context, VideosActivity::class.java))
        }

        binding.mealList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = HomeMealAdapter(context)
        }

        binding.reorderList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = OrderAgainAdapter(context)
        }

        binding.fastMealList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = HomeOffersMealAdapter(context)
        }

        binding.offersList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = HomeOffersMealAdapter(context)
        }

        binding.chefsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = FavoriteChefHomeAdapter(context)
        }

        binding.moreList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = HomeMoreMealAdapter(context)
        }

        binding.longMealList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = HomeLongMealAdapter(context)
        }

        binding.videosList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = HomeVideoAdapter(context)
        }

        binding.imageSlider.apply {
            setSliderTransformAnimation(SliderAnimations.ZOOMOUTTRANSFORMATION)
            setSliderAnimationDuration(1000)
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_RIGHT
            scrollTimeInSec = 4 //set scroll delay in seconds :
            startAutoCycle()
            setSliderAdapter(SliderHomeAdapter(context))
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.conMain.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
                if (scrollY >= oldScrollY || scrollY > 0) {
                    if (scrollY > 0){
                        binding.toolbar.alpha = (scrollY.toFloat()/500f)
                    }
                } else {
                    binding.toolbar.alpha = 0f
                }
            }
        }else{
            binding.toolbar.alpha = 1f
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}