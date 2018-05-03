package br.com.sailboat.daggerandrxjava.login

interface LoginRepository {

    fun getUser(): User?
    fun saveUser(user: User?)
}