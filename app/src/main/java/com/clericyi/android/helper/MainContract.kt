package com.clericyi.android.helper

import com.clericyi.android.helper.mvp.interf.IMvpModel

/**
 * author: ClericYi
 * time: 2021/01/05
 */
interface MainContract {

    interface Model {
        fun execute()
    }

    interface View<T: IMvpModel> {
        fun handleResponse(data: T)
    }

    interface Presenter<T: IMvpModel> {
        fun request()

        fun response(data: T)
    }

}