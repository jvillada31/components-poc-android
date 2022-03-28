package com.bedrock.components

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class ComponentsApp : Application() {

    override fun onCreate() {
        super.onCreate()

        configureLogging()
    }

    private fun configureLogging() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}
