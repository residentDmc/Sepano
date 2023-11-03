package com.example.sampleapplication.ui.view.activity

import android.os.Bundle
import android.view.View
import com.example.sampleapplication.R
import com.example.sampleapplication.utils.application.AppService.Companion.activity
import com.example.sampleapplication.utils.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity =this
        window.decorView.layoutDirection = View.LAYOUT_DIRECTION_RTL
    }
}