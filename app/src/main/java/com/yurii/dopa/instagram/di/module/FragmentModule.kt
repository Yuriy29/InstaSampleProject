package com.yurii.dopa.instagram.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.yurii.dopa.instagram.data.repository.DummyRepository
import com.yurii.dopa.instagram.data.repository.PhotoRepository
import com.yurii.dopa.instagram.data.repository.PostRepository
import com.yurii.dopa.instagram.data.repository.UserRepository
import com.yurii.dopa.instagram.di.TempDirectory
import com.yurii.dopa.instagram.ui.base.BaseFragment
import com.yurii.dopa.instagram.ui.dummies.DummiesAdapter
import com.yurii.dopa.instagram.ui.dummies.DummiesViewModel
import com.yurii.dopa.instagram.ui.home.HomeViewModel
import com.yurii.dopa.instagram.ui.home.posts.PostsAdapter
import com.yurii.dopa.instagram.ui.main.MainSharedViewModel
import com.yurii.dopa.instagram.ui.photo.PhotoViewModel
import com.yurii.dopa.instagram.ui.profile.ProfileViewModel
import com.yurii.dopa.instagram.utils.ViewModelProviderFactory
import com.yurii.dopa.instagram.utils.network.NetworkHelper
import com.yurii.dopa.instagram.utils.rx.SchedulerProvider
import com.mindorks.paracamera.Camera
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor
import java.io.File

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

    @Provides
    fun provideDummiesViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        dummyRepository: DummyRepository
    ): DummiesViewModel =
        ViewModelProviders.of(fragment,
            ViewModelProviderFactory(DummiesViewModel::class) {
                DummiesViewModel(
                    schedulerProvider,
                    compositeDisposable,
                    networkHelper,
                    dummyRepository
                )
            }
        ).get(DummiesViewModel::class.java)

    @Provides
    fun provideDummiesAdapter() = DummiesAdapter(fragment.lifecycle, ArrayList())

    @Provides
    fun providePostsAdapter() = PostsAdapter(fragment.lifecycle, ArrayList())

    @Provides
    fun provideCamera() = Camera.Builder()
        .resetToCorrectOrientation(true)// it will rotate the camera bitmap to the correct orientation from meta data
        .setTakePhotoRequestCode(1)
        .setDirectory("temp")
        .setName("camera_temp_img")
        .setImageFormat(Camera.IMAGE_JPEG)
        .setCompression(75)
        .setImageHeight(500)// it will try to achieve this height as close as possible maintaining the aspect ratio;
        .build(fragment)

    @Provides
    fun provideHomeViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        userRepository: UserRepository,
        postRepository: PostRepository
    ): HomeViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(HomeViewModel::class) {
            HomeViewModel(
                schedulerProvider, compositeDisposable, networkHelper, userRepository,
                postRepository, ArrayList(), PublishProcessor.create()
            )
        }).get(HomeViewModel::class.java)

    @Provides
    fun provideProfileViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): ProfileViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(ProfileViewModel::class) {
            ProfileViewModel(schedulerProvider, compositeDisposable, networkHelper)
        }).get(ProfileViewModel::class.java)

    @Provides
    fun providePhotoViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        userRepository: UserRepository,
        photoRepository: PhotoRepository,
        postRepository: PostRepository,
        networkHelper: NetworkHelper,
        @TempDirectory directory: File
    ): PhotoViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(PhotoViewModel::class) {
            PhotoViewModel(
                schedulerProvider, compositeDisposable, userRepository,
                photoRepository, postRepository, networkHelper, directory
            )
        }).get(PhotoViewModel::class.java)

    @Provides
    fun provideMainSharedViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): MainSharedViewModel = ViewModelProviders.of(
        fragment.activity!!, ViewModelProviderFactory(MainSharedViewModel::class) {
            MainSharedViewModel(schedulerProvider, compositeDisposable, networkHelper)
        }).get(MainSharedViewModel::class.java)
}