package com.shady.housewifekitchen.views.home.ui

import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.adapters.data.orders.OrderHomeAdapter
import com.shady.housewifekitchen.adapters.data.videos.HomeVideoAdapter
import com.shady.housewifekitchen.databinding.FragmentMenuBinding
import com.shady.housewifekitchen.databinding.FragmentMyOrderBinding
import com.shady.housewifekitchen.utils.Methods
import com.shady.housewifekitchen.utils.Methods.Companion.showMenu

class MyOrderFragment : Fragment() {

    private var _binding: FragmentMyOrderBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMyOrderBinding.inflate(inflater, container, false)

        binding.orderList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = OrderHomeAdapter(context)
        }


        binding.goMore.setOnClickListener {
            showMenu(requireContext())
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

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}