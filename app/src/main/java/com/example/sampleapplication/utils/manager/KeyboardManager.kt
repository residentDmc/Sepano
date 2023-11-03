package com.example.sampleapplication.utils.manager

import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.example.sampleapplication.utils.application.AppService


class KeyboardManager {

    fun hideKeyboard(editText: EditText) {
        val imm =AppService.activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editText.windowToken, 0);
    }

    fun hideKeyboard() {
        val v = AppService.activity.currentFocus
        val imm = AppService.activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (v != null)
            imm.hideSoftInputFromWindow(v.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    fun showKeyboard() {
        val v = AppService.activity.currentFocus
        val imm = AppService.activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (v != null)
            imm.showSoftInput(v, InputMethodManager.SHOW_IMPLICIT)
    }

}