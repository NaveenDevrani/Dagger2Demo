package com.mvvmdaggerroomdb.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.mvvmdaggerroomdb.factories.ViewModelFactory
import com.mvvmdaggerroomdb.network.RemoteDataSource
import com.mvvmdaggerroomdb.repository.AppRepository
import com.mvvmdaggerroomdb.repository.BaseRepository
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment<VM : ViewModel, B : ViewBinding> : Fragment() {
    lateinit var binding: B
    lateinit var viewModel: VM
    protected var remoteDataSource = RemoteDataSource()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        binding = getFragmentBinding(inflater, container)
        viewModel = ViewModelProvider(this, getViewModelFactory()).get(getViewModel())
        return binding.root
    }

    abstract fun getViewModel(): Class<VM>
    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B
//    abstract fun getFragmentRepository(): R
    abstract fun getViewModelFactory(): ViewModelFactory
}