package com.clericyi.android.helper

import com.clericyi.android.helper.mvp.BaseMvpPresenter

/**
 * author: ClericYi
 * time: 2021/01/04
 */
class MainMvpPresenter: BaseMvpPresenter<MainMvpActivity, MainDataSource, MainContract.Presenter>() {

    override fun getContract(): MainContract.Presenter {
        TODO("Not yet implemented")
    }

    override fun getModel(): MainDataSource {
        TODO("Not yet implemented")
    }
}