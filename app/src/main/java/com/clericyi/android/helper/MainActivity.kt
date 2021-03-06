package com.clericyi.android.helper

import android.os.Bundle
import android.widget.Toast
import com.clericyi.android.helper.mvp.BaseMvpActivity

class MainActivity : BaseMvpActivity<MainPresenter>(), MainContract.View<LoginMvpModel> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        p.request()
    }

    override fun getPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun handleResult(data: LoginMvpModel) {
        Toast.makeText(this, "handleRequest Is ${data.responseCode}", Toast.LENGTH_LONG).show()
    }
}