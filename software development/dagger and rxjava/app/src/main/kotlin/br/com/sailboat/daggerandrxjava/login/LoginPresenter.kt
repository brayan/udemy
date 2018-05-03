package br.com.sailboat.daggerandrxjava.login

class LoginPresenter(val model: LoginMVP.Model) : LoginMVP.Presenter {

    private lateinit var view: LoginMVP.View

    override fun setView(view: LoginMVP.View) {
        this.view = view
    }

    override fun loginButtonClicked() {
        if (view.getFirstName().trim().isEmpty() || view.getLastName().trim().isEmpty()) {
            view.showInputError()
        } else {
            model.createUser(view.getFirstName(), view.getLastName())
            view.showUserSavedMessage()
        }
    }

    override fun getCurrentUser() {
        var user = model.getUser()

        if (user == null) {
            view.showUserNotAvailable()
        } else {
            view.setFirstName(user.firstName)
            view.setLastName(user.lastName)
        }
    }

}