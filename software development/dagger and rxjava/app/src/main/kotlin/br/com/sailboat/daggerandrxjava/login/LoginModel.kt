package br.com.sailboat.daggerandrxjava.login

class LoginModel(private val repository: LoginRepository) : LoginMVP.Model {

    override fun createUser(firstName: String, lastName: String) {
        repository.saveUser(User(firstName = firstName, lastName = lastName))
    }

    override fun getUser(): User? = repository.getUser()

}