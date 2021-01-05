package com.clericyi.android.helper.mvp

import com.clericyi.android.helper.mvp.interf.IMvpModel
import com.clericyi.android.helper.mvp.interf.IMvpPresenter
import com.clericyi.android.helper.mvp.interf.IMvpView
import java.lang.ref.WeakReference

/**
 * author: ClericYi
 * time: 2021/01/04
 */
abstract class BaseMvpPresenter<V: IMvpView, M: IMvpModel> : IMvpPresenter {

    private var vWeakReference: WeakReference<V>? = null
    protected val model: M by lazy { createModel() }

    override fun bindView(mvpView: IMvpView) {
        vWeakReference = WeakReference(mvpView as V)
    }

    override fun unBindView() {
        if (vWeakReference != null) {
            vWeakReference?.clear()
            vWeakReference = null
        }
    }

    fun getView(): V? = vWeakReference?.get()

    abstract fun createModel(): M
}