package com.newsapp.enciyo.newapp.viewmodel

import android.arch.lifecycle.ViewModel
import android.graphics.ColorSpace
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.newsapp.enciyo.newapp.LoginResultCallBack
import com.newsapp.enciyo.newapp.model.Model

class LoginViewModel(private val listener: LoginResultCallBack) : ViewModel() {
    private var user: Model = Model("","")

    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.setEmail(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    user.setEmail(s.toString())
            }

        }

    val passwordTextWatcher:TextWatcher
        get() = object :TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    user.setPassword(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                user.setPassword(s.toString())

            }

        }

    fun onLoginClicked(v:View){
        if(user.isDataValid){
            listener.onSucces()
        }
        else{
            listener.onFailed()
        }
    }


}