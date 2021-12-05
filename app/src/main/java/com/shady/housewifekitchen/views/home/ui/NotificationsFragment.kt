package com.shady.housewifekitchen.views.home.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.adapters.data.chefs.FavoriteChefAdapter
import com.shady.housewifekitchen.adapters.data.meals.FavouriteMealAdapter
import com.shady.housewifekitchen.adapters.data.notifications.NotificationAdapter
import com.shady.housewifekitchen.databinding.FragmentNotificationsBinding
import com.shady.housewifekitchen.utils.Methods.Companion.showMenu
import com.shady.housewifekitchen.views.order.CartViewActivity

class NotificationsFragment : Fragment() {

    ///private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.favouriteList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = NotificationAdapter(context)
        }

        binding.goCart.setOnClickListener {
            startActivity(Intent(context, CartViewActivity::class.java))
        }

        binding.goMore.setOnClickListener {
            showMenu(requireContext())
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
           //// binding.favouriteList.adapter = FavoriteChefAdapter(context)
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
            //binding.favouriteList.adapter = FavouriteMealAdapter(context)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}