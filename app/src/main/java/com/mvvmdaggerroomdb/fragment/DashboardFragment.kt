package com.mvvmdaggerroomdb.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dagger2demo.R
import com.mvvmdaggerroomdb.activity.AddDetailActivity
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleClick()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DashboardFragment()
    }

    private fun handleClick() {
        addButton?.setOnClickListener {
            startActivity(Intent(context, AddDetailActivity::class.java))
        }
    }
}