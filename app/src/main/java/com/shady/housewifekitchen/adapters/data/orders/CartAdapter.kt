package com.shady.housewifekitchen.adapters.data.orders

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.views.meal.ViewMealDetailsActivity
import com.shady.housewifekitchen.views.order.CheckOutActivity

class CartAdapter (private val context: Context?) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    var selected = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {

            itemCartList.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = CartItemAdapter(context)
            }
            btnNext.setOnClickListener {
                context?.startActivity(Intent(context, CheckOutActivity::class.java))
            }
        }
    }

    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }


    override fun getItemCount(): Int {
        return 1
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemCartList: RecyclerView =itemView.findViewById(R.id.itemCartList)
        var btnNext: RelativeLayout =itemView.findViewById(R.id.btnNext)
    }
}