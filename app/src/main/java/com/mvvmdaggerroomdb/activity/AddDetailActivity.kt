package com.mvvmdaggerroomdb.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dagger2demo.R
import com.mvvmdaggerroomdb.base.BaseActivity
import com.mvvmdaggerroomdb.fragment.AddDetailFragment

class AddDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_detail)
        callFragment(AddDetailFragment.getInstance(intent.extras))
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