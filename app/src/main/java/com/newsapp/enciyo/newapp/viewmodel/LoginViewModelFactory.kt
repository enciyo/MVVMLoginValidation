package com.newsapp.enciyo.newapp.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.newsapp.enciyo.newapp.LoginResultCallBack
import com.newsapp.enciyo.newapp.viewmodel.LoginViewModel

class LoginViewModelFactory(private val listener: LoginResultCallBack): ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }

}