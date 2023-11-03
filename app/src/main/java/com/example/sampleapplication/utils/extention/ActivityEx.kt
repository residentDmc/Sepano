package com.example.sampleapplication.utils.extention

import android.app.Activity
import android.view.WindowManager
import com.example.sampleapplication.R

fun Activity.setSystemBarColor() {
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.statusBarColor = resources.getColor(R.color.primary_dark)
}