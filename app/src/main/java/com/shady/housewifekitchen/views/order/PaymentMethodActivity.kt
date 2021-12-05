package com.shady.housewifekitchen.views.order

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.shady.housewifekitchen.R
import com.shady.housewifekitchen.adapters.data.orders.PaymentMethodAdapter
import com.shady.housewifekitchen.databinding.ActivityPaymentMethodBinding
import com.shady.housewifekitchen.utils.Methods
import com.shady.housewifekitchen.views.maps.GetLocationMapsActivity

class PaymentMethodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentMethodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaymentMethodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goMore.setOnClickListener {
            Methods.showMenu(this)
        }

        binding.goBack.setOnClickListener {
            finish()
        }

        binding.btnNext.setOnClickListener {
            getDoneView()
        }

        binding.paymentList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = PaymentMethodAdapter(context)
        }
    }


    private fun getDoneView() {
        val alertDialogBuilder = AlertDialog.Builder(this,R.style.customDialog)
        val inflater = LayoutInflater.from(this)
        val dialogLayout = inflater.inflate(R.layout.popup_payment_done, null)

        alertDialogBuilder.setView(dialogLayout)
        val alertDialog = alertDialogBuilder.create()

        alertDialog.show()
    }

}