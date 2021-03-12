package com.mvvmdaggerroomdb.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dagger2demo.R
import com.mvvmdaggerroomdb.base.BaseActivity
import com.mvvmdaggerroomdb.fragment.DashboardFragment
import com.mvvmdaggerroomdb.util.AppConstant
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector

class DashboardActivity : BaseActivity() {
    var fragment: DashboardFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_dashboard)
        fragment = DashboardFragment.newInstance()
        fragment?.let { callFragment(it) }
    }

    private fun callFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragment)
        fragmentTransaction.commit()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            AppConstant.UPDATE_REQUEST_CODE -> fragment?.onActivityResult(requestCode, resultCode, data)
            else -> super.onActivityResult(requestCode, resultCode, data)
        }
    }
}