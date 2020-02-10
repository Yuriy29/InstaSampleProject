package com.yurii.dopa.instagram.ui.main

import androidx.lifecycle.MutableLiveData
import com.yurii.dopa.instagram.data.model.Post
import com.yurii.dopa.instagram.ui.base.BaseViewModel
import com.yurii.dopa.instagram.utils.common.Event
import com.yurii.dopa.instagram.utils.network.NetworkHelper
import com.yurii.dopa.instagram.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MainSharedViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    override fun onCreate() {}

    val homeRedirection = MutableLiveData<Event<Boolean>>()

    val newPost: MutableLiveData<Event<Post>> = MutableLiveData()

    fun onHomeRedirect() {
        homeRedirection.postValue(Event(true))
    }
}