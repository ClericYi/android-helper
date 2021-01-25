package com.clericyi.android.helper

import com.clericyi.android.helper.mvp.BaseMvpModel

/**
 * author: ClericYi
 * time: 2021/01/05
 */
data class LoginModel(
    val presenter: MainPresenter,
    var responseCode: String
): BaseMvpModel<MainPresenter>(presenter), MainContract.Model {
    override fun execute() {
        presenter.response(this)
    }
}