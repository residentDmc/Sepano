package com.example.sampleapplication.utils.application

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.example.sampleapplication.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class AppService : MultiDexApplication() {

    companion object {

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context

        @SuppressLint("StaticFieldLeak")
        lateinit var activity: Activity
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        context = this
        startKoin {
            androidContext(context)
            modules(listOf(appModule, adapterModule))
        }
    }
}