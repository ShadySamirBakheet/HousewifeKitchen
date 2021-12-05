package com.shady.housewifekitchen.views.videos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.adapters.data.videos.VideosViewAdapter
import com.shady.housewifekitchen.databinding.ActivityVideosBinding
import com.shady.housewifekitchen.utils.Methods

class VideosActivity : AppCompatActivity() {

    lateinit var binding: ActivityVideosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVideosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goMore.setOnClickListener {
            Methods.showMenu(this)
        }

        binding.goBack.setOnClickListener {
            finish()
        }

        binding.newCarList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = VideosViewAdapter(context)
        }

    }
}