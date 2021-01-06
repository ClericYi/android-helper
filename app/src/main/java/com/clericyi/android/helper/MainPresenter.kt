package com.clericyi.android.helper

import com.clericyi.android.helper.mvp.BaseMvpPresenter

/**
 * author: ClericYi
 * time: 2021/01/04
 */
class MainPresenter: BaseMvpPresenter<MainActivity, LoginModel>(),  MainContract.Presenter<LoginModel> {

    override fun createModel(): LoginModel {
        return LoginModel(this, 200)
    }

    override fun request() {
        model.execute()
    }

    override fun response(data: LoginModel) {
        getView()?.handleResponse(data)
    }

}