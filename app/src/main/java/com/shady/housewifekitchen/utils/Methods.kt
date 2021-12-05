package com.shady.housewifekitchen.utils

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.shady.housewifekitchen.R

class Methods {

    companion object{

        fun showMenu(context: Context){
            val alertDialogBuilder = AlertDialog.Builder(context, R.style.customDialog)
            val inflater = LayoutInflater.from(context)
            val dialogLayout = inflater.inflate(R.layout.popup_menu_main, null)

            alertDialogBuilder.setView(dialogLayout)
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }

    }

}