package com.mvvmdaggerroomdb.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dagger2demo.R
import com.mvvmdaggerroomdb.fragment.ShowDetailFragment

class ShowDetailActivity : AppCompatActivity() {
    var fragment: ShowDetailFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        fragment = ShowDetailFragment.getInstance(bundle = intent.extras)
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