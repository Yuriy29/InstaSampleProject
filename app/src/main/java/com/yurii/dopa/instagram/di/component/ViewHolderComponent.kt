package com.yurii.dopa.instagram.di.component

import com.yurii.dopa.instagram.di.ViewModelScope
import com.yurii.dopa.instagram.di.module.ViewHolderModule
import com.yurii.dopa.instagram.ui.dummies.DummyItemViewHolder
import com.yurii.dopa.instagram.ui.home.posts.PostItemViewHolder
import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {

    fun inject(viewHolder: DummyItemViewHolder)

    fun inject(viewHolder: PostItemViewHolder)
}