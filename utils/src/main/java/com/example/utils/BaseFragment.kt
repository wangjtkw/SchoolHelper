package com.example.utils

import android.util.Log
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    //暂时没用，主要是为了方便后面登录状态的确定
    protected fun init() {
        initView()
        Log.d("aaa", "$isLogin")
        if (isLogin) {
            initLogin()
        } else {
            initNotLogin()
        }
    }

    abstract fun initView()

    open fun initLogin() {}

    open fun initNotLogin() {}

    companion object {
        var isLogin = false
        var account = ""
        var userId = 0
    }
}