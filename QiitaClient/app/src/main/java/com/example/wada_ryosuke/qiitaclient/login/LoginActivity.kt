package com.example.wada_ryosuke.qiitaclient.login

import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.wada_ryosuke.qiitaclient.R
import com.example.wada_ryosuke.qiitaclient.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), LoginNavigator {

    private lateinit var mBinding: ActivityLoginBinding
    private lateinit var mViewModel: LoginViewModel

    companion object {
        private val TAG: String = LoginActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //レイアウトにバインドする。
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        mBinding.handler = this

        mBinding.loginButton.text = getString(R.string.button_login)
        mBinding.guestButton.text = getString(R.string.button_guest)

        //create instance view model
        mViewModel = LoginViewModel(this)

    }

    override fun onLoginButtonClick(v: View) {
        Log.d(TAG, "onLoginButtonClick")
        mViewModel.doLogin()
    }

    override fun onGuestButtonClick(v: View) {
        Log.d(TAG, "onGuestButtonClick")
        mViewModel.doGuestLogin()
    }

}
