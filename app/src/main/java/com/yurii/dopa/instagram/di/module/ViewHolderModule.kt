package com.yurii.dopa.instagram.di.module

import androidx.lifecycle.LifecycleRegistry
import com.yurii.dopa.instagram.di.ViewModelScope
import com.yurii.dopa.instagram.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}