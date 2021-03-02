package com.mvvmdaggerroomdb.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dagger2demo.R
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.util.AppConstant

class ShowDetailFragment : Fragment() {
    private var userModel: UserModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userModel = it.getParcelable(AppConstant.KEY_MODEL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_show_detail, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(userModel: UserModel) =
            ShowDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(AppConstant.KEY_MODEL, userModel)
                }
            }
    }
}