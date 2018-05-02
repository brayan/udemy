package br.com.sailboat.daggerandrxjava

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun prodividesApplicationContext(): Context = application

}