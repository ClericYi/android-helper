package com.clericyi.android.helper.mvp

import android.content.Context
import androidx.fragment.app.Fragment
import com.clericyi.android.helper.mvp.interf.IMvpView

/**
 * author: ClericYi
 * time: 2021/01/05
 */
abstract class BaseMvpFragment<P : BaseMvpPresenter<*, *>> : Fragment(), IMvpView {

    protected var p: P? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        p = getPresenter()
        p?.bindView(this)
    }

    override fun onDetach() {
        super.onDetach()
        p?.unBindView()
    }

    abstract fun getPresenter(): P
}