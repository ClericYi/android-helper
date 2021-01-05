package com.clericyi.android.helper.mvp

import com.clericyi.android.helper.mvp.interf.IMvpDataSource
import com.clericyi.android.helper.mvp.interf.IMvpPresenter

/**
 * author: ClericYi
 * time: 2021/01/05
 */
abstract class BaseDataSource<P: IMvpPresenter> (val p: P): IMvpDataSource