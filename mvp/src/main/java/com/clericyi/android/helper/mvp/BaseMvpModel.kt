package com.clericyi.android.helper.mvp

import com.clericyi.android.helper.mvp.interf.IMvpModel
import com.clericyi.android.helper.mvp.interf.IMvpPresenter

/**
 * author: ClericYi
 * time: 2021/01/05
 */
abstract class BaseMvpModel<P: IMvpPresenter> (val p: P): IMvpModel