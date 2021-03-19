package com.mvvmdaggerroomdb.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.dagger2demo.R
import com.dagger2demo.databinding.FragmentAddDetailBinding
import com.mvvmdaggerroomdb.activity.AddDetailActivity
import com.mvvmdaggerroomdb.base.BaseFragment
import com.mvvmdaggerroomdb.factories.ViewModelFactory
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.util.AppConstant
import com.mvvmdaggerroomdb.util.Util
import com.mvvmdaggerroomdb.viewmodels.AddDetailViewModel
import kotlinx.android.synthetic.main.fragment_add_detail.*
import javax.inject.Inject


class AddDetailFragment : BaseFragment<AddDetailViewModel, FragmentAddDetailBinding>() {
    private var userModel: UserModel? = null
    private var isEdit: Boolean = false

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            userModel = it.getParcelable(AppConstant.KEY_USER_MODEL)
            isEdit = it.getBoolean(AppConstant.IS_EDIT)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        if (isEdit) {
            binding.tvTitle.text = getString(R.string.update_profile)
            userModel?.let {
                viewModel.userModel = it
                viewModel.isEdit = true
            }
            binding.executePendingBindings()
        }

        handleObserver()

        viewModel.getCountriesList()
    }

    companion object {
        fun newInstance(userModel: UserModel, isEdit: Boolean) =
            AddDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(AppConstant.KEY_USER_MODEL, userModel)
                    putBoolean(AppConstant.IS_EDIT, isEdit)
                }
            }

        fun getInstance(bundle: Bundle?) = AddDetailFragment().apply { arguments = bundle }
    }

    override fun getViewModel() = AddDetailViewModel::class.java

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentAddDetailBinding.inflate(inflater, container, false)

    private fun handleObserver() {
        viewModel.validationError.observe(viewLifecycleOwner,
            {
                when (it) {
                    AppConstant.KEY_NAME -> {
                        editTextName?.error = getString(R.string.required)
                        editTextName?.requestFocus()
                    }

                    AppConstant.KEY_ADDRESS -> {
                        editTextAddress?.error = getString(R.string.required)
                        editTextAddress?.requestFocus()
                    }

                    AppConstant.KEY_COUNTRY ->
                        Util.showToast(getString(R.string.country_empty_error))
                }
            })

        viewModel.countryObserver.observe(viewLifecycleOwner, {
            it?.let {
                val countryList = ArrayList<String>()
                it.forEach { countryModel ->
                    if (!countryModel.name.isNullOrEmpty()) {
                        countryList.add(countryModel.name)
                    }
                }
                handleSpinner(countryList)
            }
        })

        viewModel.successObserver.observe(viewLifecycleOwner, {
            next()
        })
    }

    fun next() {
        activity?.let {
            if (it is AddDetailActivity) it.goToDashboard(Activity.RESULT_OK)
        }
    }

    override fun getViewModelFactory() = factory


    private fun handleSpinner(list: List<String>) {
        context?.let {
            val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(it, android.R.layout.simple_spinner_item, list)
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner?.adapter = arrayAdapter
            spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    viewModel.userModel.country = parent.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
            if (isEdit) {
                list.forEachIndexed { index, s ->
                    if (s == userModel?.country ?: "") {
                        spinner?.setSelection(index)
                        return@forEachIndexed
                    }
                }
            }
        }
    }
}