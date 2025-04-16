package com.danielaboros.appandroid

import android.app.Application
import com.danielaboros.appandroid.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(AppModule)
        }
    }
}