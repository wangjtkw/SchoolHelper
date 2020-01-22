package com.example.schoolhelper

interface MainConstValue {
    val tabSelectedDrawableIdList: Array<Int>
        get() = arrayOf(
            R.drawable.ic_findteam_tab_color,
            R.drawable.ic_consult_tab_color,
            //因为现在还没图标，所以先代替一下
            R.drawable.ic_consult_tab_color,
            R.drawable.ic_mine_tab_color
        )

    val tabUnselectedDrawableList: Array<Int>
        get() = arrayOf(
            R.drawable.ic_findteam_tab,
            R.drawable.ic_consult_tab,
            //因为现在还没图标，所以先代替一下
            R.drawable.ic_consult_tab,
            R.drawable.ic_mine_tab
        )

    val tabText: Array<String> get() = arrayOf("找团队", "咨询", "社区", "我的")
}