package com.mvvmdaggerroomdb.util

import android.widget.Toast
import com.mvvmdaggerroomdb.activity.AppActivity

object Util {
    fun showToast(message:String) {
        Toast.makeText(AppActivity.getContext(),message,Toast.LENGTH_LONG).show()
    }
}