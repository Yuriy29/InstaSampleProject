package com.yurii.dopa.instagram.di.component

import com.yurii.dopa.instagram.di.FragmentScope
import com.yurii.dopa.instagram.di.module.FragmentModule
import com.yurii.dopa.instagram.ui.dummies.DummiesFragment
import com.yurii.dopa.instagram.ui.home.HomeFragment
import com.yurii.dopa.instagram.ui.photo.PhotoFragment
import com.yurii.dopa.instagram.ui.profile.ProfileFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(fragment: DummiesFragment)

    fun inject(fragment: ProfileFragment)

    fun inject(fragment: PhotoFragment)

    fun inject(fragment: HomeFragment)
}