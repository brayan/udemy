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
    fun loadTheUserFromRepositoryWhenValidUserIsPresent() {
        `when`(mockLoginModel.getUser()).thenReturn(user)

        presenter.getCurrentUser()

        verify(mockLoginModel, times(1)).getUser()

        verify(mockView, times(1)).setFirstName("Fox")
        verify(mockView, times(1)).setLastName("Mulder")
        verify(mockView, never()).showUserNotAvailable()
    }


    @Test
    fun shouldShowErrorMessageWhenUserIsNull() {
        `when`(mockLoginModel.getUser()).thenReturn(null)

        presenter.getCurrentUser()

        verify(mockLoginModel, times(1)).getUser()

        verify(mockView, never()).setFirstName("Fox")
        verify(mockView, never()).setLastName("Mulder")
        verify(mockView, times(1)).showUserNotAvailable()
    }

    @Test
    fun shouldCreateErrorMessageIfFieldsAreEmpty() {
        `when`(mockView.getFirstName()).thenReturn("")

        presenter.loginButtonClicked()

        `when`(mockView.getFirstName()).thenReturn("Dana")
        `when`(mockView.getLastName()).thenReturn("")

        presenter.loginButtonClicked()

        verify(mockView, times(2)).getFirstName()
        verify(mockView, times(1)).getLastName()
        verify(mockView, times(2)).showInputError()


    }

    @Test
    fun shouldBeAbleToSaveAValidUser() {
        `when`(mockView.getFirstName()).thenReturn("Dana")
        `when`(mockView.getLastName()).thenReturn("Scully")

        presenter.loginButtonClicked()

        verify(mockView, times(2)).getFirstName()
        verify(mockView, times(2)).getLastName()

        verify(mockLoginModel, times(1)).createUser("Dana", "Scully")
        verify(mockView, times(1)).showUserSavedMessage()
    }

}