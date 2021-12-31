package com.bornbytes.mybaseapplication.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.bornbytes.mybaseapplication.api.RemoteDataSource
import com.bornbytes.mybaseapplication.api.RemoteResult
import com.bornbytes.mybaseapplication.repository.BaseRepository
import com.bornbytes.mybaseapplication.util.showSnackBar

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding, R : BaseRepository> : Fragment() {

    abstract fun getViewModelClass(): Class<VM>

    abstract fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): VB

    abstract fun getFragmentRepository(): R

    lateinit var binding: VB
    lateinit var viewModel: VM
    val remoteDataSource = RemoteDataSource()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)
        val factory = ViewModelFactory(getFragmentRepository())
        viewModel = ViewModelProvider(this, factory).get(getViewModelClass())
        return binding.root
    }

    fun handleApiError(failure: RemoteResult.Failure){
        when {
            failure.isNetworkError -> requireView().showSnackBar("Please check your network connection...")
            failure.errorCode == 401 -> { viewModel.logoutUser(remoteDataSource.buildApi()) }
            else -> requireView().showSnackBar(failure.errorMessage?.string() ?: "Network issue")
        }
    }
}
