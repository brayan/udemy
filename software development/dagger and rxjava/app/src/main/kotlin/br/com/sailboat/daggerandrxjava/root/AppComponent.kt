package br.com.sailboat.daggerandrxjava.root

import br.com.sailboat.daggerandrxjava.login.LoginActivity
import br.com.sailboat.daggerandrxjava.login.LoginModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, LoginModule::class])
interface AppComponent {

    fun inject(activity: LoginActivity)
}