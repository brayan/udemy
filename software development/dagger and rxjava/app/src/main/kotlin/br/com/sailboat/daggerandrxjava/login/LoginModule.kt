package br.com.sailboat.daggerandrxjava.login

import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun providesLoginPresenter(model: LoginMVP.Model) : LoginMVP.Presenter {
        return LoginPresenter(model)
    }

    @Provides
    fun providesLoginModel(loginRepository: LoginRepository) : LoginMVP.Model {
        return LoginModel(loginRepository)
    }

    @Provides
    fun providesLoginRepository() : LoginRepository {
        return MemoryRepository()
    }

}