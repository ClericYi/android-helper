package com.clericyi.android.helper.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clericyi.android.helper.mvp.interf.IMvpView

/**
 * author: ClericYi
 * time: 2021/01/04
 */
abstract class BaseMvpActivity<P : BaseMvpPresenter<*, *>> : AppCompatActivity(), IMvpView {

    protected var p: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        p = getPresenter()
        p?.bindView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        p?.unBindView()
    }

    abstract fun getPresenter(): P
}