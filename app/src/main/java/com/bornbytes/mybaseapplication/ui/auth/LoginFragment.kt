package com.bornbytes.mybaseapplication.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bornbytes.mybaseapplication.api.RemoteResult
import com.bornbytes.mybaseapplication.databinding.LoginFragmentBinding
import com.bornbytes.mybaseapplication.repository.AuthRepository
import com.bornbytes.mybaseapplication.ui.base.BaseFragment
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : BaseFragment<AuthViewModel, LoginFragmentBinding, AuthRepository>() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = LoginFragmentBinding.inflate(inflater, container, false)

    override fun getViewModelClass() = AuthViewModel::class.java

    override fun getFragmentRepository() =
        AuthRepository(remoteDataSource.buildApi())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            when (it) {
                is RemoteResult.Success -> {
                    //Show api success state ui
                }
                is RemoteResult.Failure -> handleApiError(it)
                is RemoteResult.Loading -> {
                    //Show loading indicator
                }
            }
        })

        btnGetOtp.setOnClickListener { viewModel.loginUser() }

    }


}