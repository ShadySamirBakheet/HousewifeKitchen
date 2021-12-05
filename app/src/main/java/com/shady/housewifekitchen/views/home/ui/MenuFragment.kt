package com.shady.housewifekitchen.views.home.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.adapters.data.videos.HomeVideoAdapter
import com.shady.housewifekitchen.databinding.FragmentMenuBinding
import com.shady.housewifekitchen.utils.Methods

class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)


        binding.goMore.setOnClickListener {
            Methods.showMenu(requireContext())
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