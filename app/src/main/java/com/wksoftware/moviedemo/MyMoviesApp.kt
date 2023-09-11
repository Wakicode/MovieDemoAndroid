package com.wksoftware.moviedemo


import android.app.Application
import com.wksoftware.moviedemo.di.AppModule
import com.wksoftware.moviedemo.di.AppModuleImpl

class MyMoviesApp: Application()
{
    companion object{
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this)
    }
}