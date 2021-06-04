package com.mvvmdaggerroomdb.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dagger2demo.R
import com.mvvmdaggerroomdb.base.BaseActivity
import com.mvvmdaggerroomdb.fragment.ShowDetailFragment

class ShowDetailActivity : BaseActivity() {
    lateinit var fragment: ShowDetailFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        fragment = ShowDetailFragment.getInstance(bundle = intent.extras)
        callFragment(fragment)
    }

    private fun callFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragment)
        fragmentTransaction.commit()
    }

    private fun goToDashboard() {
        setResult(RESULT_CANCELED)
        finish()
    }

    override fun onBackPressed() {
        goToDashboard()
    }
}