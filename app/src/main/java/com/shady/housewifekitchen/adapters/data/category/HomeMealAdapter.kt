package com.shady.housewifekitchen.adapters.data.category

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.views.meal.MealCategoryActivity
import com.shady.housewifekitchen.views.meal.ViewMealDetailsActivity

class HomeMealAdapter  (private val context: Context?) : RecyclerView.Adapter<HomeMealAdapter.ViewHolder>() {

    var selected = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_type_meal, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            itemView.setOnClickListener {
                context?.startActivity(Intent(context, MealCategoryActivity::class.java))
            }

        }
    }


    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }


    override fun getItemCount(): Int {
        return 6
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        ////var imgItem: ImageView =itemView.findViewById(R.id.imgItem)
    }
}