package com.shady.housewifekitchen.adapters.data.orders

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shady.housewifekitchen.R

class OrderHomeAdapter (private val context: Context?) : RecyclerView.Adapter<OrderHomeAdapter.ViewHolder>() {

    var selected = -1
    var status = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_order_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {

            if (position == selected){
                infoCon.visibility = VISIBLE
                moreBtn.setImageResource(R.drawable.ic_more_less)
            }else{
                infoCon.visibility = GONE
                moreBtn.setImageResource(R.drawable.ic_more_more)
            }

            moreBtn.setOnClickListener {
                val lastp = selected
                if (infoCon.visibility == VISIBLE){
                    selected = -1
                    infoCon.visibility = GONE
                    moreBtn.setImageResource(R.drawable.ic_more_more)
                }else{
                    selected = position
                    infoCon.visibility = VISIBLE
                    moreBtn.setImageResource(R.drawable.ic_more_less)
                }
                notifyItemChanged(lastp)
            }

            orderItemList.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = OrderHomeItemAdapter(context)
            }

        }
    }


    private var onItemClickListener: ((Int) -> Unit)? = null

    fun setOnItemClickListener(listener: (Int) -> Unit) {
        onItemClickListener = listener
    }


    override fun getItemCount(): Int {
        return 10
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var moreBtn: ImageView =itemView.findViewById(R.id.moreBtn)
        var infoCon: RelativeLayout =itemView.findViewById(R.id.infoCon)
        var orderItemList: RecyclerView =itemView.findViewById(R.id.orderItemList)
    }
}