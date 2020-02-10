package com.yurii.dopa.instagram.ui.profile

import com.yurii.dopa.instagram.ui.base.BaseViewModel
import com.yurii.dopa.instagram.utils.network.NetworkHelper
import com.yurii.dopa.instagram.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class ProfileViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {


    override fun onCreate() {

    }
}