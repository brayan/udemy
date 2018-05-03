package br.com.sailboat.daggerandrxjava.login

interface LoginMVP {

    interface View {
        fun getFirstName(): String
        fun getLastName(): String

        fun showUserNotAvailable()
        fun showInputError()
        fun showUserSavedMessage()

        fun setFirstName(firstName: String)
        fun setLastName(lastName: String)
    }

    interface Presenter {
        fun setView(view: LoginMVP.View)
        fun loginButtonClicked()
        fun getCurrentUser()
    }

    interface Model {
        fun createUser(firstName: String, lastName: String)
        fun getUser(): User?
    }

}