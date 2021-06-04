package com.mvvmdaggerroomdb.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dagger2demo.R
import com.mvvmdaggerroomdb.base.BaseActivity
import com.mvvmdaggerroomdb.fragment.DashboardFragment

class DashboardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        callFragment(DashboardFragment.newInstance())
    }

    private fun callFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragment)
        fragmentTransaction.commit()
    }
}