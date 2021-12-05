package com.shady.housewifekitchen.views.home.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.adapters.data.chefs.FavoriteChefAdapter
import com.shady.housewifekitchen.adapters.data.chefs.FavoriteChefHomeAdapter
import com.shady.housewifekitchen.adapters.data.meals.FavouriteMealAdapter
import com.shady.housewifekitchen.databinding.FragmentFavouriteBinding
import com.shady.housewifekitchen.utils.Methods
import com.shady.housewifekitchen.views.order.CartViewActivity

class FavouriteFragment : Fragment() {

    //private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentFavouriteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.favouriteList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = FavoriteChefAdapter(context)
        }

        binding.btnChefs.setOnClickListener {
            binding.btnChefs.apply {
                setBackgroundResource(R.drawable.btnblack4)
                setTextColor(resources.getColor(R.color.white))
            }
            binding.btnMeals.apply {
                setBackgroundResource(R.drawable.btnborder3)
                setTextColor(resources.getColor(R.color.black))
            }
            binding.favouriteList.adapter = FavoriteChefAdapter(context)
        }

        binding.goCart.setOnClickListener {
            startActivity(Intent(context, CartViewActivity::class.java))
        }

        binding.btnMeals.setOnClickListener {
            binding.btnChefs.apply {
                setBackgroundResource(R.drawable.btnborder3)
                setTextColor(resources.getColor(R.color.black))
            }
            binding.btnMeals.apply {
                setBackgroundResource(R.drawable.btnblack4)
                setTextColor(resources.getColor(R.color.white))
            }
            binding.favouriteList.adapter = FavouriteMealAdapter(context)
        }

        binding.goMore.setOnClickListener {
            Methods.showMenu(requireContext())
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}