package com.mvvmdaggerroomdb.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dagger2demo.R
import com.dagger2demo.databinding.FragmentDashboardBinding
import com.mvvmdaggerroomdb.UserItemClickListener
import com.mvvmdaggerroomdb.activity.AddDetailActivity
import com.mvvmdaggerroomdb.activity.ShowDetailActivity
import com.mvvmdaggerroomdb.adapter.UserAdapter
import com.mvvmdaggerroomdb.factories.ViewModelFactory
import com.mvvmdaggerroomdb.model.UserModel
import com.mvvmdaggerroomdb.util.AppConstant
import com.mvvmdaggerroomdb.util.ViewUtil.hide
import com.mvvmdaggerroomdb.util.ViewUtil.show
import com.mvvmdaggerroomdb.viewmodels.DashBoardViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_dashboard.*
import javax.inject.Inject

class DashboardFragment : Fragment(), UserItemClickListener {

    private var viewModel: DashBoardViewModel? = null
    private var myAdapter: UserAdapter? = null
    private var binding: FragmentDashboardBinding? = null

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.fragment_dashboard, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProvider(this, factory).get(DashBoardViewModel::class.java)
        handleClick()
        setRecyclerView()
        handleObserver()
    }

    private fun setRecyclerView() {
        myAdapter = UserAdapter(this)
        myAdapter?.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                tvNoData?.visibility = if (myAdapter?.itemCount == 0) View.VISIBLE else View.GONE
                super.onChanged()
            }
        })
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            val dividerItemDecoration = DividerItemDecoration(activity, RecyclerView.VERTICAL)
            context?.let { context ->
                ContextCompat.getDrawable(context, R.drawable.recyclerview_divider)?.let { drawable ->
                    dividerItemDecoration.setDrawable(drawable)
                    addItemDecoration(dividerItemDecoration)
                }
            }
            this.adapter = myAdapter
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = DashboardFragment()
    }

    private fun handleClick() {
        addButton?.setOnClickListener {
            startForResult.launch(Intent(context, AddDetailActivity::class.java))
        }
    }

    private fun handleObserver() {
        viewModel?.progressBarObserver?.observe(viewLifecycleOwner, {
            if (it)
                progressBar?.show()
            else progressBar?.hide()
        })
        viewModel?.getUserList()?.observe(viewLifecycleOwner, {

            it?.let {
                myAdapter?.setData(it as ArrayList<UserModel>)
            } ?: run {
                myAdapter?.setData(ArrayList())
            }
        })

        viewModel?.deleteUserObserver?.observe(viewLifecycleOwner, {
            getAllUser()
        })

        getAllUser()
    }

    private fun getAllUser() {
        viewModel?.getUser()
    }

    override fun onClickItem(user: UserModel) {
        activity?.let {
            val bundle = Bundle()
            bundle.putParcelable(AppConstant.KEY_USER_MODEL, user)
            val intent = Intent(it, ShowDetailActivity::class.java).also { intent -> intent.putExtras(bundle) }
            startForResult.launch(intent)
        }
    }

    override fun onEdit(user: UserModel, position: Int) {
        activity?.let {
            val bundle = Bundle()
            bundle.putParcelable(AppConstant.KEY_USER_MODEL, user)
            bundle.putBoolean(AppConstant.IS_EDIT, true)
            val intent = Intent(it, AddDetailActivity::class.java).putExtras(bundle)
            startForResult.launch(intent)
        }
    }

    override fun onDelete(user: UserModel, position: Int) {
        viewModel?.deleteUser(user)
    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            getAllUser()
        }
    }

}