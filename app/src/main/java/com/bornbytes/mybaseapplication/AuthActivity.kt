package com.bornbytes.mybaseapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bornbytes.mybaseapplication.ui.auth.LoginFragment
import com.bornbytes.mybaseapplication.util.replaceFragment

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        if (savedInstanceState == null)
            supportFragmentManager.replaceFragment(R.id.container, LoginFragment.newInstance())

    }
}