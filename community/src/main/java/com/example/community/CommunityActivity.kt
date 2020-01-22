package com.example.community

import android.os.Bundle
import android.widget.FrameLayout
import com.example.community.databinding.ActivityCommunityBinding
import com.example.utils.BaseActivity
import com.example.utils.statusbar.StatusBarUtil
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_community.*

class CommunityActivity : BaseActivity<ActivityCommunityBinding>(), MainConstValue {
    private lateinit var frame: FrameLayout
    private lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        //以StatusBarUtil开头的方法都是用于设置状态栏的
        //下面两个方法需要在setContentView之前
        StatusBarUtil.setRootViewFitsSystemWindows(this, true)
        StatusBarUtil.setTranslucentStatus(this)
        super.onCreate(savedInstanceState)
        //初始化dataBinding
        initBinding()
        //如果状态栏字体的颜色不为黑色或者白色，则设置其他颜色
        if (!StatusBarUtil.setStatusBarDarkTheme(this, false)) {
            StatusBarUtil.setStatusBarColor(this, 0x55000000)
        }
        //true：支持右滑返回
        canSlideFinish(false)
        init()
    }

    private fun init() {
        frame = frame_community
        tabLayout = tb_layout_community
        initTabLayout()
        initFragment()
    }

    //fragment跳转
    private fun initFragment() {
        supportFragmentManager.beginTransaction().add(R.id.frame_community, CommunityFragment()).commit()
    }

    private fun initTabLayout() {
        //为TabLayout添加内容
        for (i: Int in 0 until tabText.size) {
            tabLayout.addTab(tabLayout.newTab().setText(tabText[i]).setIcon(tabList[i]))
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_community
    }
}