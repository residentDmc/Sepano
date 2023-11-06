package com.example.sampleapplication.utils.extention

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE


fun Context.initVersion(): String = packageManager.getPackageInfo(packageName, 0).versionName


fun Activity.getMemoryInfo(): String {
    val memoryInfo = ActivityManager.MemoryInfo()
    val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
    activityManager.getMemoryInfo(memoryInfo)
    val runtime = Runtime.getRuntime()
    val availableMemory = memoryInfo.availMem
    val totalMemory = memoryInfo.totalMem
    val maxMemory = runtime.maxMemory()
    val totalMemoryRuntime = runtime.totalMemory()
    val freeMemoryRuntime = runtime.freeMemory()

    val availableMemoryStr = formatMemorySize(availableMemory)
    val totalMemoryStr = formatMemorySize(totalMemory)
    val maxMemoryStr = formatMemorySize(maxMemory)
    val totalMemoryRuntimeStr = formatMemorySize(totalMemoryRuntime)
    val freeMemoryRuntimeStr = formatMemorySize(freeMemoryRuntime)
    return """
             حافظه موجود: $availableMemoryStr
             کل حافظه: $totalMemoryStr
             حداکثر حافظه: $maxMemoryStr
             کل حافظه (زمان اجرا): $totalMemoryRuntimeStr
             حافظه رایگان (Runtime): $freeMemoryRuntimeStr
             """.trimIndent()
}

private fun formatMemorySize(size: Long): String {
    return if (size < 1024) {
        size.toString() + "B"
    } else if (size < 1024 * 1024) {
        (size / 1024).toString() + "KB"
    } else if (size < 1024 * 1024 * 1024) {
        (size / (1024 * 1024)).toString() + "MB"
    } else {
        (size / (1024 * 1024 * 1024)).toString() + "GB"
    }
}

