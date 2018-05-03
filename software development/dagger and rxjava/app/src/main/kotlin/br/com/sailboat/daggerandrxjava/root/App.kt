package br.com.sailboat.daggerandrxjava.root

import android.app.Application
import br.com.sailboat.daggerandrxjava.login.LoginModule

class App : Application() {

    lateinit var appComponent: AppComponent;

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .loginModule(LoginModule())
            .build()
    }
}