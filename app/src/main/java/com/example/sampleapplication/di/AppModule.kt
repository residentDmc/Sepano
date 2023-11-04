package com.example.sampleapplication.di

import androidx.navigation.Navigation
import com.example.sampleapplication.R
import com.example.sampleapplication.utils.application.AppService.Companion.activity
import com.example.sampleapplication.utils.manager.GridLayoutCountManager
import com.example.sampleapplication.utils.manager.KeyboardManager
import com.example.sampleapplication.utils.tools.HandleErrorTools
import com.example.sampleapplication.utils.tools.ToastTools
import org.koin.dsl.module


val appModule = module {
    single { initNavController() }
    single { return@single ToastTools() }
    single { return@single HandleErrorTools() }
    single { return@single GridLayoutCountManager(get()) }
    single { return@single KeyboardManager() }
}

private fun initNavController() =
    Navigation.findNavController(activity, R.id.my_nav_fragment)
