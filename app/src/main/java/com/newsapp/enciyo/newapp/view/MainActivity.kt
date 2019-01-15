package com.newsapp.enciyo.newapp.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.newsapp.enciyo.newapp.LoginResultCallBack
import com.newsapp.enciyo.newapp.R
import com.newsapp.enciyo.newapp.databinding.ActivityMainBinding
import com.newsapp.enciyo.newapp.viewmodel.LoginViewModel
import com.newsapp.enciyo.newapp.viewmodel.LoginViewModelFactory
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(), LoginResultCallBack {
    override fun onSucces() {
        Toasty.success(this,"Succes", Toast.LENGTH_SHORT).show()
    }

    override fun onFailed() {
        Toasty.error(this,"Error", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        activityMainBinding.viewModel=ViewModelProviders.of(this,
            LoginViewModelFactory(this)
        )
            .get(LoginViewModel::class.java)
    }
}
