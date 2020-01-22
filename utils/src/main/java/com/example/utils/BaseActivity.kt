package com.example.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.utils.myview.SlideFinishLayout

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {
    protected lateinit var binding: T
    //给fragment注册点击事件

    //右滑活动返回相关变量↓↓↓↓↓↓↓↓
    private var startInAnimationResources = 0
    private var startOutAnimationResources = 0
    private var finishInAnimationResources = 0
    private var finishOutAnimationResources = 0  //活动进出动画
    private var isInAnimated = false//是否是初次创建的resume

    private var slideFinishLayout: SlideFinishLayout<T>? = null
    //右滑活动返回相关变量↑↑↑↑↑↑↑↑

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //设置活动切换动画
        setInOutAnimation(
            R.anim.slide_in_right,
            R.anim.slide_out_left,
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )

    }

    protected fun initBinding() {
        //初始化DataBinding
        binding = DataBindingUtil.setContentView(this, getLayoutId())
    }

    //获取子Activity的Layout
    abstract fun getLayoutId(): Int

    override fun onResume() {
        super.onResume()

        //设置活动进入动画
        if (startOutAnimationResources != 0) {
            if (!isInAnimated) {
                overridePendingTransition(startInAnimationResources, startOutAnimationResources)
                isInAnimated = true
            }
        }
    }

    override fun finish() {
        super.finish()
        //设置活动退出动画
        if (finishInAnimationResources != 0) {
            overridePendingTransition(finishInAnimationResources, finishOutAnimationResources)
        }
        slideFinishLayout?.detachToActivity()
    }

    /**
     * 右滑活动返回相关↓↓↓↓↓↓↓↓
     */
    fun canSlideFinish(isCanBack: Boolean, needDoOther: Boolean = false, callback: () -> Unit = {}) {
        if (isCanBack) {
            initSlideFinish(needDoOther, callback)
        }
    }

    private fun initSlideFinish(needDoOther: Boolean = false, callback: () -> Unit = {}) {
        slideFinishLayout = LayoutInflater.from(this).inflate(
            R.layout.slidefinish_container, null
        ) as? SlideFinishLayout<T>
        slideFinishLayout!!.attachToActivity(this, needDoOther, callback)
    }

    fun addIgnoredView(v: View) {
        slideFinishLayout?.addIgnoredView(v)
    }

    fun setInOutAnimation(
        startInAnimationResources: Int, startOutAnimationResources: Int,
        finishInAnimationResources: Int, finishOutAnimationResources: Int
    ) {
        this.startInAnimationResources = startInAnimationResources
        this.startOutAnimationResources = startOutAnimationResources
        this.finishInAnimationResources = finishInAnimationResources
        this.finishOutAnimationResources = finishOutAnimationResources
    }


}


