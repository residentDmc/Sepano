package com.example.sampleapplication.utils.extention

import android.content.Context

fun Context.initVersion(): String = packageManager.getPackageInfo(packageName, 0).versionName

