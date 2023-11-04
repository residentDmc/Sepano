package com.example.sampleapplication.di

import com.example.sampleapplication.ui.view.adapter.BluetoothAdapter
import org.koin.dsl.module

val adapterModule = module {
    single { return@single BluetoothAdapter(get()) }

}