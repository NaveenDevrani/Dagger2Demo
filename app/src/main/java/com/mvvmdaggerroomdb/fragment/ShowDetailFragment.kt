package com.mvvmdaggerroomdb.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dagger2demo.databinding.FragmentShowDetailBinding
import com.mvvmdaggerroomdb.base.BaseFragment
import com.mvvmdaggerroomdb.factories.ViewModelFactory
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.util.AppConstant
import com.mvvmdaggerroomdb.viewmodels.AddDetailViewModel
import javax.inject.Inject

class ShowDetailFragment : BaseFragment<AddDetailViewModel, FragmentShowDetailBinding>() {
    private var userModel: UserModel? = null

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userModel = it.getParcelable(AppConstant.KEY_USER_MODEL)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            userModel = it.getParcelable(AppConstant.KEY_USER_MODEL)
        }

        userModel?.let {
            binding.lifecycleOwner = this
            binding.user = it
            binding.executePendingBindings()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(userModel: UserModel) =
            ShowDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(AppConstant.KEY_USER_MODEL, userModel)
                }
            }

        fun getInstance(bundle: Bundle?) = ShowDetailFragment().apply { arguments = bundle }

    }

    override fun getViewModel() = AddDetailViewModel::class.java

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentShowDetailBinding.inflate(inflater, container, false)
    override fun getViewModelFactory() = factory

}