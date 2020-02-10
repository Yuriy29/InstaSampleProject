package com.yurii.dopa.instagram.di.component

import com.yurii.dopa.instagram.di.ActivityScope
import com.yurii.dopa.instagram.di.module.ActivityModule
import com.yurii.dopa.instagram.ui.dummy.DummyActivity
import com.yurii.dopa.instagram.ui.login.LoginActivity
import com.yurii.dopa.instagram.ui.main.MainActivity
import com.yurii.dopa.instagram.ui.splash.SplashActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: SplashActivity)

    fun inject(activity: LoginActivity)

    fun inject(activity: DummyActivity)

    fun inject(activity: MainActivity)
}