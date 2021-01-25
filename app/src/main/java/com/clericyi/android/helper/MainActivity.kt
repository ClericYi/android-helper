package com.clericyi.android.helper

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.clericyi.android.helper.databinding.ActivityMain1Binding
import com.clericyi.android.helper.mvp.BaseMvpActivity


class MainActivity : BaseMvpActivity<MainPresenter>(), MainContract.View<LoginModel> {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        val ac = DataBindingUtil.setContentView<ActivityMain1Binding>(this, R.layout.activity_main1)
        ac.user = p?.let { LoginModel(it, "200") }
//        p?.request()
        findViewById<Button>(R.id.button).setOnClickListener {
            ac.user = p?.let { LoginModel(it, "100") }
        }
    }

    override fun getPresenter(): MainPresenter {
        return MainPresenter()
    }

    override fun handleResponse(data: LoginModel) {
        Toast.makeText(this, "handleRequest Is ${data.responseCode}", Toast.LENGTH_LONG).show()
    }
}