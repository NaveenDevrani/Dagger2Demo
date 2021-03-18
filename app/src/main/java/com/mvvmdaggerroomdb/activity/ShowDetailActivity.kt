package com.mvvmdaggerroomdb.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dagger2demo.R
import com.mvvmdaggerroomdb.base.BaseActivity
import com.mvvmdaggerroomdb.fragment.ShowDetailFragment

class ShowDetailActivity : BaseActivity() {
    var fragment: ShowDetailFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        fragment = ShowDetailFragment.getInstance(bundle = intent.extras)
        callFragment(fragment!!)
    }

    private fun callFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragment)
        fragmentTransaction.commit()
    }

    fun goToDashboard(isResult: Int) {
        setResult(isResult)
        finish()
    }

    override fun onBackPressed() {
        goToDashboard(RESULT_CANCELED)
    }
}