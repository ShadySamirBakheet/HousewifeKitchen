package com.shady.housewifekitchen.adapters.slider

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.shady.housewifekitchen.R
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderMealAdapter (var context: Context?): SliderViewAdapter<SliderMealAdapter.SliderAdapterVH>() {

    var size = 8

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_meal_slider, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        viewHolder.apply {
            when(position){
                0->imgItem.setImageResource(R.drawable.image1)
                1->imgItem.setImageResource(R.drawable.image2)
                2->imgItem.setImageResource(R.drawable.image3)
                3->imgItem.setImageResource(R.drawable.image4)
                4->imgItem.setImageResource(R.drawable.image5)
                5->imgItem.setImageResource(R.drawable.image6)
                6->imgItem.setImageResource(R.drawable.image7)
            }
        }
    }


    override fun getCount(): Int {
        return size
    }

    inner class SliderAdapterVH(view: View) : ViewHolder(view) {
        var imgItem: ImageView =itemView.findViewById(R.id.imgItem)
    }
}