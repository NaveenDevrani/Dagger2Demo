package com.mvvmdaggerroomdb.util

import android.widget.Toast
import com.mvvmdaggerroomdb.activity.AndroidApplication

object Util {
    fun showToast(message: String) {
        Toast.makeText(AndroidApplication.getContext(), message, Toast.LENGTH_LONG).show()
    }

    fun getString(stringId: Int): String {
        return AndroidApplication.getContext().getString(stringId)
    }
}