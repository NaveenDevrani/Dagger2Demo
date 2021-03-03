package com.mvvmdaggerroomdb.util

import android.view.View
import android.widget.ProgressBar

object ViewUtil {

    fun ProgressBar.show() {
        visibility = View.VISIBLE
    }

    fun ProgressBar.hide() {
        visibility = View.GONE
    }
}