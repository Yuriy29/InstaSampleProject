package com.yurii.dopa.instagram.ui.dummy

import com.yurii.dopa.instagram.data.repository.DummyRepository
import com.yurii.dopa.instagram.ui.base.BaseViewModel
import com.yurii.dopa.instagram.utils.network.NetworkHelper
import com.yurii.dopa.instagram.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable


class DummyViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val dummyRepository: DummyRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    override fun onCreate() {
        // do something
    }
}