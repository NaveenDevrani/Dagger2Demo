package com.mvvmdaggerroomdb.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dagger2demo.R
import com.dagger2demo.databinding.FragmentAddDetailBinding
import com.mvvmdaggerroomdb.activity.AddDetailActivity
import com.mvvmdaggerroomdb.base.BaseFragment
import com.mvvmdaggerroomdb.database.AppDataBase
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.network.ApiService
import com.mvvmdaggerroomdb.network.RemoteDataSource
import com.mvvmdaggerroomdb.repository.AddDetailRepository
import com.mvvmdaggerroomdb.util.AppConstant
import com.mvvmdaggerroomdb.viewmodels.AddDetailViewModel
import kotlinx.android.synthetic.main.fragment_add_detail.*
import java.util.*

class AddDetailFragment : BaseFragment<AddDetailViewModel, FragmentAddDetailBinding, AddDetailRepository>() {
    private var userModel: UserModel? = null
    private var isEdit: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userModel = it.getParcelable(AppConstant.KEY_MODEL)
            isEdit = it.getBoolean(AppConstant.IS_EDIT)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    companion object {
        fun newInstance(userModel: UserModel, isEdit: Boolean) =
            AddDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(AppConstant.KEY_MODEL, userModel)
                    putBoolean(AppConstant.IS_EDIT, isEdit)
                }
            }

        fun getInstance(bundle: Bundle?) = AddDetailFragment().apply { arguments = bundle }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        handleObserver()
    }

    override fun getViewModel() = AddDetailViewModel::class.java

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentAddDetailBinding.inflate(inflater, container, false)

    private fun handleObserver() {
        viewModel.validationError.observe(viewLifecycleOwner,
            {
                when (it) {
                    1 -> {
                        editTextName?.error = getString(R.string.required)
                        editTextName?.requestFocus()
                    }
                    2 -> {
                        editTextAddress?.error = getString(R.string.required)
                        editTextAddress?.requestFocus()
                    }
                }
            })

        viewModel.successObserver.observe(viewLifecycleOwner, {
            next()
        })
    }

    override fun getFragmentRepository(): AddDetailRepository {
        return AddDetailRepository(RemoteDataSource().buildApi(ApiService::class.java), AppDataBase.invoke())
    }

    fun next() {
        activity?.let {
            if (it is AddDetailActivity) it.goToDashboard(Activity.RESULT_OK)
        }
    }

}