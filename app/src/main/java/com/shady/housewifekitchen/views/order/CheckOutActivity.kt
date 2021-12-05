package com.shady.housewifekitchen.views.order

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.adapters.data.orders.CartItemAdapter
import com.shady.housewifekitchen.databinding.ActivityCheckOutBinding
import com.shady.housewifekitchen.databinding.ActivitySignupBinding
import com.shady.housewifekitchen.utils.Methods
import com.shady.housewifekitchen.views.maps.GetLocationMapsActivity

class CheckOutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCheckOutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCheckOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goMore.setOnClickListener {
            Methods.showMenu(this)
        }

        binding.goBack.setOnClickListener {
            finish()
        }

        binding.itemCartList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CartItemAdapter(context)
        }

        binding.country.adapter = ArrayAdapter(this, R.layout.item_spinner, arrayOf("Egypt","Egypt","Egypt","Egypt"))
        binding.state.adapter = ArrayAdapter(this, R.layout.item_spinner, arrayOf("State ","State ","State ",))
        binding.area.adapter = ArrayAdapter(this, R.layout.item_spinner, arrayOf("Area","Area","Area",))

        binding.btnLocation.setOnClickListener {
            getLocationView()
        }

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this,PaymentMethodActivity::class.java))
        }

    }


    private fun getLocationView() {
        val alertDialogBuilder = AlertDialog.Builder(this,R.style.customDialog)
        val inflater = LayoutInflater.from(this)
        val dialogLayout = inflater.inflate(R.layout.popup_location, null)

        alertDialogBuilder.setView(dialogLayout)
        val alertDialog = alertDialogBuilder.create()

        dialogLayout.findViewById<TextView>(R.id.btnAnother).setOnClickListener {
            startActivity(Intent(this,GetLocationMapsActivity::class.java))
            alertDialog.dismiss()
        }

        dialogLayout.findViewById<TextView>(R.id.btnCurrent).setOnClickListener {
            startActivity(Intent(this,GetLocationMapsActivity::class.java))
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

}