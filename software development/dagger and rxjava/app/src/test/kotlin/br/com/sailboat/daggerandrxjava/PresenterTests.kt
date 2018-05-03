package br.com.sailboat.daggerandrxjava

import br.com.sailboat.daggerandrxjava.login.LoginMVP
import br.com.sailboat.daggerandrxjava.login.LoginPresenter
import br.com.sailboat.daggerandrxjava.login.User
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class PresenterTests {

    lateinit var mockLoginModel: LoginMVP.Model
    lateinit var mockView: LoginMVP.View
    lateinit var presenter: LoginPresenter
    lateinit var user: User


    @Before
    fun setUp() {
        mockLoginModel = mock(LoginMVP.Model::class.java)

        user = User(
            firstName = "Fox",
            lastName = "Mulder"
        )

        `when`(mockLoginModel.getUser()).thenReturn(user)

        mockView = mock(LoginMVP.View::class.java)

        presenter = LoginPresenter(mockLoginModel)

        presenter.setView(mockView)

    }

    @Test
    fun noInteractionWirhViewTest() {
        presenter.getCurrentUser()

        verifyZeroInteractions(mockView)
    }

}