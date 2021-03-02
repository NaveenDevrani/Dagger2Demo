package com.mvvmdaggerroomdb.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dagger2demo.R
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.util.AppConstant

class AddDetailFragment : Fragment() {
    private var userModel: UserModel? = null
    private var isEdit: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userModel = it.getParcelable(AppConstant.KEY_MODEL)
            isEdit = it.getBoolean(AppConstant.IS_EDIT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_detail, container, false)
    }

    companion object {
        fun newInstance(userModel: UserModel, isEdit: Boolean) =
            AddDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(AppConstant.KEY_MODEL, userModel)
                    putBoolean(AppConstant.IS_EDIT, isEdit)
                }
            }
    }
}