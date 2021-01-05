package com.clericyi.android.helper.mvp.`interface`

/**
 * author: ClericYi
 * time: 2021/01/04
 */
interface IMvpPresenter {
    fun bindView(mvpView: IMvpView)

    fun unBindView()

    fun createModel(): IMvpModel
}