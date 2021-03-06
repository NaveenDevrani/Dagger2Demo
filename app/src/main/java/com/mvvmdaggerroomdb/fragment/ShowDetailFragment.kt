package com.mvvmdaggerroomdb.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dagger2demo.R
import com.dagger2demo.databinding.FragmentShowDetailBinding
import com.mvvmdaggerroomdb.base.BaseFragment
import com.mvvmdaggerroomdb.database.AppDataBase
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.network.ApiService
import com.mvvmdaggerroomdb.network.RemoteDataSource
import com.mvvmdaggerroomdb.repository.AppRepository
import com.mvvmdaggerroomdb.util.AppConstant
import com.mvvmdaggerroomdb.viewmodels.AddDetailViewModel

class ShowDetailFragment : BaseFragment<AddDetailViewModel, FragmentShowDetailBinding, AppRepository>() {
    private var userModel: UserModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userModel = it.getParcelable(AppConstant.KEY_MODEL)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            userModel = it.getParcelable(AppConstant.KEY_MODEL)
        }

        userModel?.let {
            binding.lifecycleOwner = this
            binding.user = it
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(userModel: UserModel) =
            ShowDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(AppConstant.KEY_MODEL, userModel)
                }
            }

        fun getInstance(bundle: Bundle?) = ShowDetailFragment().apply { arguments = bundle }

    }

    override fun getViewModel() = AddDetailViewModel::class.java

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentShowDetailBinding.inflate(inflater, container, false)

    override fun getFragmentRepository(): AppRepository {
        return AppRepository(RemoteDataSource().buildApi(ApiService::class.java), AppDataBase.invoke())
    }
}