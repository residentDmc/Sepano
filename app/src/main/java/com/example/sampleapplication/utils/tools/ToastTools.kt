package com.example.sampleapplication.utils.tools

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.sampleapplication.R
import com.example.sampleapplication.utils.application.AppService


@Suppress("DEPRECATION")
class ToastTools {

    fun toast(message: String) {
        val layout: View = AppService.activity.layoutInflater.inflate(
            R.layout.toast_layout,
            AppService.activity.findViewById<View>(R.id.custom_toast_layout_id) as ViewGroup?)
        val text = layout.findViewById<View>(R.id.text) as TextView
        text.setTextColor(Color.WHITE)
        text.text = message
        val lytCard = layout.findViewById<View>(R.id.lyt_card) as CardView
        lytCard.setCardBackgroundColor(AppService.activity.resources.getColor(R.color.colorBlack))

        val toast = Toast(AppService.activity)
        toast.duration = Toast.LENGTH_LONG
        toast.view = layout
        toast.show()
    }
}