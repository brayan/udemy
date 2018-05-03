package br.com.sailboat.daggerandrxjava.login

class MemoryRepository : LoginRepository {

    private var user: User? = null

    override fun getUser(): User? {
        if (user == null) {
            val user = User(0, "Fox", "Mulder")
            return user
        } else {
            return user
        }
    }

    override fun saveUser(user: User?) {
        if (user == null) {
            this.user = getUser()
        } else {
            this.user = user
        }

    }

}