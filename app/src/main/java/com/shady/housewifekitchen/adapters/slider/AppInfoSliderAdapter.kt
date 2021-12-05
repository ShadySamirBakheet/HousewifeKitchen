package com.shady.housewifekitchen.adapters.slider

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.views.loginsystem.SplashLogin2Activity
import com.smarteist.autoimageslider.SliderViewAdapter


class AppInfoSliderAdapter (var context: Context?): SliderViewAdapter<AppInfoSliderAdapter.SliderAdapterVH>() {

    inner class SliderAdapterVH(view: View) : SliderViewAdapter.ViewHolder(view) {
        val btnSkip: TextView = itemView.findViewById(R.id.btnSkip)
    }

    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapterVH {
        val inflate: View =
            LayoutInflater.from(parent?.context).inflate(R.layout.item_slider_infoapp, null)
        return SliderAdapterVH(inflate)
    }

    override fun getCount(): Int {
        return 8
    }

    override fun destroyItem(container: View, position: Int, `object`: Any) {
        if (position == 6){
            context?.startActivity(Intent(context, SplashLogin2Activity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }

        super.destroyItem(container, position, `object`)
    }



    override fun onBindViewHolder(viewHolder: SliderAdapterVH?, position: Int) {
        viewHolder?.apply {

            if (position == 6){
                btnSkip.text = "Finish"
            }else{
                btnSkip.text = "Sikp"
            }

            btnSkip.setOnClickListener {
                context?.startActivity(
                    Intent(context, SplashLogin2Activity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
            }

        }
    }
}