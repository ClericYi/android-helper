package com.clericyi.android.helper.mvp

import com.clericyi.android.helper.mvp.`interface`.IModel
import com.clericyi.android.helper.mvp.`interface`.IPresenter
import com.clericyi.android.helper.mvp.`interface`.IView
import java.lang.ref.WeakReference

/**
 * author: ClericYi
 * time: 2021/01/04
 */
abstract class BasePresenter<V: IView, M: IModel> : IPresenter {

    private var vWeakReference: WeakReference<V>? = null
    protected val model: IModel by lazy { createModel() }

    override fun bindView(view: IView) {
        vWeakReference = WeakReference(view as V)
    }

    override fun unBindView() {
        if (vWeakReference != null) {
            vWeakReference?.clear()
            vWeakReference = null
        }
    }

    fun getView(): IView? = vWeakReference?.get()

    abstract fun createModel(): IModel
}