package com.newsapp.enciyo.newapp.model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns


class Model(private var email:String,private var password:String) : BaseObservable(){
    val isDataValid:Boolean
    get() = (!TextUtils.isEmpty(email)
            && Patterns.EMAIL_ADDRESS.matcher(email).matches()
            && password.length>6)

    fun setEmail(mail:String){email=mail}
    fun setPassword(pswd:String){password=pswd}


}